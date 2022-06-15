package com.example.ps_shop_android.data.mapper

import com.example.ps_shop_android.data.database.ProductDbModel
import com.example.ps_shop_android.data.network.model.ProductDto
import com.example.ps_shop_android.domain.model.Product
import javax.inject.Inject

class ProductMapper @Inject constructor() {

    fun mapDtoToDbModel(dto: ProductDto) = ProductDbModel(
        id = dto.id,
        name = dto.name,
        picture = dto.picture,
        description = dto.description,
        price = dto.price,
        categoryId = dto.categoryId,
    )

    fun mapDbModelToEntity(dbModel: ProductDbModel) = Product(
        id = dbModel.id,
        name = dbModel.name,
        picture = dbModel.picture,
        description = dbModel.description,
        price = dbModel.price,
        categoryId = dbModel.categoryId,
    )

    fun mapEntityToDbModel(product: Product) = ProductDbModel(
        id = product.id,
        name = product.name,
        picture = product.picture,
        description = product.description,
        price = product.price,
        categoryId = product.categoryId,
    )
}