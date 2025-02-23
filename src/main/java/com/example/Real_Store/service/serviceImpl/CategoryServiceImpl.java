package com.example.Real_Store.service.serviceImpl;

//import com.example.Real_Store.conversion.ConversionClass;
import com.example.Real_Store.conversion.ConversionClass;
import com.example.Real_Store.dto.CategoryDTO;
import com.example.Real_Store.entity.Category;
import com.example.Real_Store.repository.CategoryRepository;
//import com.example.Real_Store.repository.ProductRepository;
import com.example.Real_Store.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public ConversionClass conversionClass;
//    @Autowired
//    public ProductRepository productRepository;

//    @Override
//    public CategoryDTO addCategory(CategoryDTO categoryDTO){
//        if(categoryDTO.getName()!=null){
//            Category category = conversionClass.CategoryDTO_To_CategoryEntity(categoryDTO);
//            categoryRepository.save(category);
//            logger.error("REAL_STORE: ADD CATEGORY- category added for Name {}",categoryDTO.getName());
//            return conversionClass.CategoryEntity_To_CategoryDTO(category);
//        }else{
//            logger.error("REAL_STORE: ADD CATEGORY- categoryDTO should not be null {}",categoryDTO);
//        }
//        return null;
//    }
//
    @Override
    public CategoryDTO getCategoryById(Long categoryId) {

        try{
            if(categoryId!=null){
                Category category = categoryRepository.findById(categoryId).get();
                CategoryDTO categoryDTO = conversionClass.CategoryEntity_To_CategoryDTO(category);
                logger.error("REAL_STORE: GET CATEGORY BY ID- category retrieved by Id {}",categoryId);
                return categoryDTO;
            }
        }catch (Exception e){
            logger.error("REAL_STORE: GET CATEGORY BY ID- categoryId not found {}",categoryId);
        }
        return null;
    }
//
//    @Override
//    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
//        Long categoryId = categoryDTO.getCategoryId();
//        Category category = categoryRepository.findById(categoryId).get();
//        category.setName(categoryDTO.getName());
//        category.setDescription(categoryDTO.getDescription());
//        CategoryDTO categoryDTO1 = conversionClass.CategoryEntity_To_CategoryDTO(category);
//        logger.info("REAL_STORE: UPDATE CATEGORY- category updated for Id {}", categoryId);
//        return categoryDTO1;
//    }
//
//    @Override
//    public String deleteCategoryById(Long categoryId) {
//        try{
//            if(categoryId != null){
//                categoryRepository.deleteById(categoryId);
//                logger.error("REAL_STORE: DELETE CATEGORY BY ID- category deleted for Id {}",categoryId);
//                return "category deleted";
//            }
//        }catch (Exception e){
//            logger.error("REAL_STORE: DELETE CATEGORY BY ID- categoryId not found {}",categoryId);
//            return  "category not found";
//        }
//        return null;
//    }

    @Override
    public List<Category> getAllCategory()  {
        return  categoryRepository.findAll().stream().toList();
    }
}
