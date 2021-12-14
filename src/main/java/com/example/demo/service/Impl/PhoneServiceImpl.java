package com.example.demo.service.Impl;

import com.example.demo.entity.PhoneCategory;
import com.example.demo.entity.PhoneInfo;
import com.example.demo.entity.PhoneSpecs;
import com.example.demo.enums.ResultEnums;
import com.example.demo.exception.PhoneException;
import com.example.demo.repository.PhoneCategoryRepository;
import com.example.demo.repository.PhoneInfoRepository;
import com.example.demo.repository.PhoneSpecRepository;
import com.example.demo.service.PhoneService;
import com.example.demo.util.PhoneUtil;
import com.example.demo.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private PhoneSpecRepository phoneSpecRepository;


    @Override
    public DataVO findDataVO(){
        DataVO dataVO = new DataVO();

        List<PhoneCategory> phoneCategoryList = phoneCategoryRepository.findAll();
        List<CategoriesVO> categoriesVOList = phoneCategoryList.stream()
                .map(e -> new CategoriesVO(
                        e.getCategoryName(),
                        e.getCategoryType()
                )).collect(Collectors.toList());
        dataVO.setCategories(categoriesVOList);

        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAll();
        List<PhonesVO> phonesVOList = phoneInfoList.stream()
                .map(e -> new PhonesVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice(),
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
        dataVO.setPhones(phonesVOList);

        return dataVO;
    }
    @Override
    public List<PhonesVO> findPhoneInfoByCategoryType(Integer categoryType){
        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAllByCategoryType(categoryType);
        List<PhonesVO> phonesVOList = phoneInfoList.stream()
                .map(e -> new PhonesVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice(),
                        e.getPhoneDescription(),
                        PhoneUtil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());
        return phonesVOList;
    }
    @Override
    public SpecsVO findSpecsByPhoneId(Integer phoneId){
        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneId).get();
        List<PhoneSpecs> phoneSpecsList = phoneSpecRepository.findAllByPhoneId(phoneId);

        //Tree、List
        List<SpecsCaseVO> specsCaseVOList = new ArrayList<>();
        List<ListVO> listVOList = new ArrayList<>();

        SpecsCaseVO specsCaseVo;
        ListVO listVO;
        for (PhoneSpecs phoneSpecs : phoneSpecsList){
            specsCaseVo = new SpecsCaseVO();
            listVO = new ListVO();
            BeanUtils.copyProperties(phoneSpecs,specsCaseVo);
            System.out.println("111111111111111111"+specsCaseVo);
            BeanUtils.copyProperties(phoneSpecs,listVO);
            System.out.println("222222222222222222"+listVO);

            specsCaseVOList.add(specsCaseVo);
            listVOList.add(listVO);
        }
        TreeVO treeVO = new TreeVO();
        treeVO.setV(specsCaseVOList);
        List<TreeVO> treeVOList = new ArrayList<>();
        treeVOList.add(treeVO);
        //SkuVO
        SkuVO skuVO = new SkuVO();
        Integer price = phoneInfo.getPhonePrice().intValue();
        skuVO.setPrice(price+".00");
        skuVO.setStock_num(phoneInfo.getPhoneStock());
        skuVO.setTree(treeVOList);
        skuVO.setList(listVOList);
        //SpecVO
        SpecsVO specsVO = new SpecsVO();
        specsVO.setSku(skuVO);
        Map<String,String> goods = new HashMap<>();
        goods.put("picture",phoneInfo.getPhoneIcon());
        specsVO.setGoods(goods);

        return specsVO;
    }

    @Override
    public void subStock(Integer specsId, Integer quantity) {
        PhoneSpecs phoneSpecs = phoneSpecRepository.findById(specsId).get();
        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        //Specs减库存
        Integer result = phoneSpecs.getSpecsStock() - quantity;
        if(result == 0){
            log.error("库存不足");
            throw new PhoneException(ResultEnums.PHONE_STOCK_ERROR);
        }
        phoneSpecs.setSpecsStock(result);
        phoneSpecRepository.save(phoneSpecs);
        //Info减库存
        result = phoneInfo.getPhoneStock() - quantity;
        if(result == 0){
            log.error("库存不足");
            throw new PhoneException(ResultEnums.PHONE_STOCK_ERROR);
        }
        phoneInfo.setPhoneStock(result);
        phoneInfoRepository.save(phoneInfo);
    }

}
