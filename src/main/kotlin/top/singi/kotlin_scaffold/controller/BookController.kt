package top.singi.kotlin_scaffold.controller

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import top.singi.kotlin_scaffold.entity.Book
import top.singi.kotlin_scaffold.service.BookService

@RestController
@RequestMapping("/book")
class BookController {

    @Autowired
    lateinit var bookService: BookService

    @GetMapping
    fun index(
        @RequestParam(name = "page", required = false, defaultValue = "1") page: Long,
        @RequestParam(name = "per_page", required = false, defaultValue = "10") perPage: Long,
        @RequestParam(name = "search", required = false, defaultValue = "") search: String
    ): HashMap<String, Any> {
        val queryWrapper = QueryWrapper<Book>()
        if (search.isNotBlank()) {
            queryWrapper.like("title", search)
        }

        queryWrapper.orderByDesc("id")

        val pagination = Page<Book>(page, perPage)
        val bookPage = bookService.page(pagination, queryWrapper)

        val map = HashMap<String, Any>()
        map["total"] = bookPage.total
        map["items"] = bookPage.records

        return map
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id") id: Int): Book {
        return bookService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody book: Book): Boolean {
        return bookService.save(book)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody book: Book, @PathVariable("id") id: Int): Boolean {
        book.id = id
        return bookService.updateById(book)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int): Boolean {
        return bookService.removeById(id)
    }
}