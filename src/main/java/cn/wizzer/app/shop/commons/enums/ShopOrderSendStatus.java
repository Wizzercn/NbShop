package cn.wizzer.app.shop.commons.enums;

import org.nutz.json.JsonShape;

/**
 * 订单发货状态
 * Created by wizzer on 2019/6/12
 */
@JsonShape(JsonShape.Type.OBJECT)
public enum ShopOrderSendStatus {
    WAIT(0, "待发货"),
    SEND(1, "已发货"),
    TAKE(2, "已收货"),
    APPLY(3, "申请退货"),
    RETURN(4, "已退货");

    private int value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopOrderSendStatus(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public int value() {
        return value;
    }

    public String text() {
        return text;
    }

    public static ShopOrderSendStatus from(int value) {
        for (ShopOrderSendStatus t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopOrderSendStatus: " + value);
    }

}
