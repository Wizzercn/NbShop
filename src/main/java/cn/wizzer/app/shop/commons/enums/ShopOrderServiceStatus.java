package cn.wizzer.app.shop.commons.enums;

import org.nutz.json.JsonShape;

/**
 * 订单收货状态
 * Created by wizzer on 2019/6/12
 */
@JsonShape(JsonShape.Type.OBJECT)
public enum ShopOrderServiceStatus {
    WAIT(0, "待处理"),
    CHECKED(1, "审核通过"),
    UNCHECK(2, "审核未通过"),
    FNISH(3, "处理完成");

    private int value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopOrderServiceStatus(int value, String text) {
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

    public static ShopOrderServiceStatus from(int value) {
        for (ShopOrderServiceStatus t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopOrderServiceStatus: " + value);
    }

}
