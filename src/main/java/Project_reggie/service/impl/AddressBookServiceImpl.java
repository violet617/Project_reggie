package Project_reggie.service.impl;

import Project_reggie.entity.AddressBook;
import Project_reggie.mapper.AddressBookMapper;
import Project_reggie.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
