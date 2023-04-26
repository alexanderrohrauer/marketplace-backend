package com.example.marketplacebackend.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAuction is a Querydsl query type for Auction
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAuction extends EntityPathBase<Auction> {

    private static final long serialVersionUID = -444005654L;

    public static final QAuction auction = new QAuction("auction");

    public final ListPath<Bid, QBid> bids = this.<Bid, QBid>createList("bids", Bid.class, QBid.class, PathInits.DIRECT2);

    public final EnumPath<Category> category = createEnum("category", Category.class);

    public final EnumPath<ItemCondition> condition = createEnum("condition", ItemCondition.class);

    public final DateTimePath<java.time.Instant> createdAt = createDateTime("createdAt", java.time.Instant.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath seller = createString("seller");

    public final StringPath title = createString("title");

    public final DateTimePath<java.time.Instant> updatedAt = createDateTime("updatedAt", java.time.Instant.class);

    public QAuction(String variable) {
        super(Auction.class, forVariable(variable));
    }

    public QAuction(Path<? extends Auction> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuction(PathMetadata metadata) {
        super(Auction.class, metadata);
    }

}

