package com.example.ps_shop_android.data.mapper

import com.example.ps_shop_android.data.network.model.ProductDto
import com.example.ps_shop_android.domain.model.Product

class ProductMapper {

    fun mapDtoToEntity(dto: ProductDto) = Product(
        name = dto.name,
        picture = dto.picture,
        description = dto.description,
        price = dto.price,
        categoryId = dto.categoryId,
        id = dto.id,
    )
}