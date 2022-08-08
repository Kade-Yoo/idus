package kr.idus.homework.order.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kr.idus.homework.member.model.MemberResponse;
import kr.idus.homework.order.entity.Order;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@ApiModel(value = "주문 정보")
public class OrderResponse {

    @ApiModelProperty(name = "주문 번호", dataType = "String")
    private String orderNo;

    @ApiModelProperty(name = "상품 번호", dataType = "String")
    private String productNo;

    @ApiModelProperty(name = "상품명", dataType = "String")
    private String productNm;

    @ApiModelProperty(name = "회원 정보", dataType = "Object")
    private MemberResponse member;

    @ApiModelProperty(name = "주문 일자", dataType = "Date")
    private LocalDateTime orderDate;

    public static OrderResponse of(Order order) {
        OrderResponse response = new OrderResponse();
        response.orderNo = order.getOrderNo();
        response.productNo = order.getProduct().getProductNo();
        response.productNm = order.getProduct().getProductNm();
        response.member = MemberResponse.of(order.getMember());
        response.orderDate = order.getOrderDate();
        return response;
    }
}
