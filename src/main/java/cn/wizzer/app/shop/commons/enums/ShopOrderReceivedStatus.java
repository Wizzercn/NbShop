package cn.wizzer.app.shop.commons.enums;

import org.nutz.json.JsonShape;

/**
 * 订单收货状态
 * Created by wizzer on 2019/6/12
 */
@JsonShape(JsonShape.Type.OBJECT)
public enum ShopOrderReceivedStatus {
    WAIT(0, "未收货"),
    RECEIVED(1, "已收货");

    private int value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopOrderReceivedStatus(int value, String text) {
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

    public static ShopOrderReceivedStatus from(int value) {
        for (ShopOrderReceivedStatus t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopOrderReceivedStatus: " + value);
    }

}
