package com.example.demo.service.Impl;

import com.example.demo.entity.BuyerAddress;
import com.example.demo.form.AddressForm;
import com.example.demo.repository.BuyerAddressRepository;
import com.example.demo.service.AddressService;
import com.example.demo.vo.AddressVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private BuyerAddressRepository buyerAddressRepository;

    @Override
    public List<AddressVO> findAll(){
        List<BuyerAddress> buyerAddressList = buyerAddressRepository.findAll();
        List<AddressVO> addressVOList = new ArrayList<>();
        AddressVO addressVO;
        for(BuyerAddress buyerAddress : buyerAddressList){
            addressVO = new AddressVO();
            BeanUtils.copyProperties(buyerAddress,addressVO);
            System.out.println(addressVO);
            addressVOList.add(addressVO);
        }
        return addressVOList;
    }

    @Override
    public void saveOrUpdate(AddressForm addressForm){
        BuyerAddress buyerAddress;
        if(addressForm.getId() == null){
            buyerAddress = new BuyerAddress();
        }
        else {
            buyerAddress = buyerAddressRepository.findById(addressForm.getId()).get();
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        //省市区拼接
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());

        buyerAddress.setBuyerAddress(stringBuffer.toString());
        buyerAddress.setAreaCode(addressForm.getAreaCode());

        buyerAddressRepository.save(buyerAddress);
    }
}
