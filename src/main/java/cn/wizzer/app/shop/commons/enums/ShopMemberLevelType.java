package cn.wizzer.app.shop.commons.enums;

import org.nutz.json.JsonShape;

/**
 * 会员等级类型
 * Created by wizzer on 2019/6/12
 */
@JsonShape(JsonShape.Type.OBJECT)
public enum ShopMemberLevelType {
    MEMBER(0, "个人会员"),
    WHOLESALE(1, "批发商"),
    DEALER(2, "零售商");

    private int value;//千万不要用final修饰符
    private String text; //千万不要用final修饰符

    ShopMemberLevelType(int value, String text) {
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

    public static ShopMemberLevelType from(int value) {
        for (ShopMemberLevelType t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        throw new IllegalArgumentException("unknown ShopMemberLevelType: " + value);
    }

}
