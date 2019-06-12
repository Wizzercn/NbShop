package cn.wizzer.app.shop.commons.enums;

import org.nutz.json.JsonShape;

/**
 * 订单评价状态
 * Created by wizzer on 2019/6/12
 */
@JsonShape(JsonShape.Type.OBJECT)
public enum ShopOrderAssessStatus {
    WAIT(0, "待评价"),
    ALREADY(1, "已评价");

    private int value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopOrderAssessStatus(int value, String text) {
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

    public static ShopOrderAssessStatus from(int value) {
        for (ShopOrderAssessStatus t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopOrderAssessStatus: " + value);
    }

}
