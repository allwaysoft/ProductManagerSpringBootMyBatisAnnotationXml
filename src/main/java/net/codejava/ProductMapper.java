package net.codejava;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ProductMapper {

    int listAllSortPageContainingCount(String keyword);

    @Select("select * from product WHERE CONCAT(id, ' ', name, ' ' , brand, ' ' , madein, ' ' , price) LIKE CONCAT('%',#{keyword},'%')  order by ${sortField}  ${sortDir} LIMIT ${pageSize} OFFSET ${pageOffset}")
    List<Product> listAllSortPageContaining(@Param("keyword") String keyword, @Param("sortField") String sortField, @Param("sortDir") String sortDir, @Param("pageSize") Integer pageSize, @Param("pageOffset") Long pageOffset);
//    @Select("select count(*) from product WHERE CONCAT(id, ' ', name, ' ' , brand, ' ' , madein, ' ' , price) LIKE CONCAT('%',#{keyword},'%')  ")

}
