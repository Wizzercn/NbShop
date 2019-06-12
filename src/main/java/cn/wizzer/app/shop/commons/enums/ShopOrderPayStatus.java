package cn.wizzer.app.shop.commons.enums;

import org.nutz.json.JsonShape;

/**
 * 订单支付状态
 * Created by wizzer on 2019/6/12
 */
@JsonShape(JsonShape.Type.OBJECT)
public enum ShopOrderPayStatus {
    WAIT(0, "待支付"),
    PAYED(1, "已付款"),
    APPLY(2, "申请退款"),
    REFUND(3, "已退款");

    private int value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopOrderPayStatus(int value, String text) {
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

    public static ShopOrderPayStatus from(int value) {
        for (ShopOrderPayStatus t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopOrderPayStatus: " + value);
    }

}
