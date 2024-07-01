package top.singi.kotlin_scaffold.service

import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service
import top.singi.kotlin_scaffold.entity.Book
import top.singi.kotlin_scaffold.mapper.BookMapper

@Service
class BookService : IService<Book>, ServiceImpl<BookMapper, Book>() {
}