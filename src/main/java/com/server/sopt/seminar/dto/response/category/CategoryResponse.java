package com.server.sopt.seminar.dto.response.category;
import com.server.sopt.seminar.domain.Category;
import lombok.Data;

@Data
public class CategoryResponse {
    private String content;

    public CategoryResponse(String content) {
        this.content = content;
    }

    public static CategoryResponse of(Category category) {
        return new CategoryResponse(category.getContent());
    }
}