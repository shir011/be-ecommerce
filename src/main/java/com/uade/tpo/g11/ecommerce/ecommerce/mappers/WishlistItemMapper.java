package com.uade.tpo.g11.ecommerce.ecommerce.mappers;

import com.uade.tpo.g11.ecommerce.ecommerce.dtos.WishlistItemDTO;
import com.uade.tpo.g11.ecommerce.ecommerce.entities.ProductEntity;
import com.uade.tpo.g11.ecommerce.ecommerce.entities.WishlistEntity;
import com.uade.tpo.g11.ecommerce.ecommerce.entities.WishlistItemEntity;
import com.uade.tpo.g11.ecommerce.ecommerce.repositories.IProductRepository;
import com.uade.tpo.g11.ecommerce.ecommerce.repositories.IWishlistItemRepository;
import com.uade.tpo.g11.ecommerce.ecommerce.repositories.IWishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishlistItemMapper {

    @Autowired
    IWishlistRepository wishlistRepository;

    @Autowired
    WishlistMapper wishlistMapper;

    @Autowired
    IProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public WishlistItemDTO toDTO(WishlistItemEntity wishlistItemEntity) {
        WishlistItemDTO wishlistItemDTO = new WishlistItemDTO();

        // ID Setter
        wishlistItemDTO.setWishlistItemId(wishlistItemEntity.getWishlistItemId());

        // Wishlist Setter
        WishlistEntity wishlistEntity = wishlistRepository.findById(wishlistItemEntity.getWishlistItemId()).orElse(null);
        wishlistItemDTO.setWishlist(wishlistMapper.toDTO(wishlistEntity));

        // Product Setter
        ProductEntity productEntity = productRepository.findById(wishlistItemEntity.getProduct().getProductId()).orElse(null);
        wishlistItemDTO.setProduct(productMapper.toDTO(productEntity));

        return wishlistItemDTO;
    }

    public WishlistItemEntity toEntity(WishlistItemDTO wishlistItemDTO) {
        WishlistItemEntity wishlistItemEntity = new WishlistItemEntity();

        // ID Setter
        wishlistItemEntity.setWishlistItemId(wishlistItemDTO.getWishlistItemId());

        // Wishlist Setter
        wishlistItemEntity.setWishlist(wishlistMapper.toEntity(wishlistItemDTO.getWishlist()));

        // Product Setter
        wishlistItemEntity.setProduct(productMapper.toEntity(wishlistItemDTO.getProduct()));

        return wishlistItemEntity;
    }

}