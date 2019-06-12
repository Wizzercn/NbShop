package cn.wizzer.app.shop.commons.enums;

import org.nutz.json.JsonShape;

/**
 * 订单发货状态
 * Created by wizzer on 2019/6/12
 */
@JsonShape(JsonShape.Type.OBJECT)
public enum ShopOrderSendType {
    SELF(0, "商家配送"),
    EXPRESS(1, "物流公司");

    private int value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopOrderSendType(int value, String text) {
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

    public static ShopOrderSendType from(int value) {
        for (ShopOrderSendType t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopOrderSendType: " + value);
    }

}
