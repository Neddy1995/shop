#数据字典

##user用户信息表

字段|名称|注释
--|:--:|--:
user_id|用户id|
user_name|用户名|
password|密码|
age|年龄|
sex|性别|0为女，1为男
profession|职业|
regtime|注册时间|
power|权限|0为管理员，1为用户，2为商家

##address地址信息表

字段|名称|注释
--|:--:|--:
address_id|地址id|
address_name|地址名|
address_phone|地址电话|
address_prov|地址省份|
address_city|地址城市|
address_area|地址区县|
address_street|地址街道|
address_info|地址详情|
user_id|用户id|外键关联用户

##shopping_cart购物车信息表

字段|名称|注释
--|:--:|--:
cart_id|购物车id|
user_id|用户id|用户外键
number|数量|
good_id|商品id|商品外键

##favorite收藏夹

字段|名称|注释
--|:--:|--:
favorite_id|收藏夹id|
user_id|用户id|外键
good_id|商品id|
time|收藏时间|

##order_goods商品订单

字段|名称|注释
--|:--:|--:
order_id|订单id|
begin_time|开始时间|
end_time|结束时间|
state|状态|0为未支付，1为已支付未发货，2为已发货，3为已收货未确认，4已确认完成结束
user_id|用户id|用户外键
address_id|地址id|地址外键

##order_detail订单详情

字段|名称|注释
--|:--:|--:
detail_id|详情id|
good_id|商品id|
number|数量|
order_id|订单id|订单外键

##goods_type商品类型表

字段|名称|注释
--|:--:|--:
type_id|类型id|
good_type_id|商品类别id|外键
good_type_name|商品类别名称|

##good_brand_info商品品牌表

字段|名称|注释
--|:--:|--:
id|自增序列|主键，不做任何业务
good_type_id|商品类别id|
brand_id|品牌id|

##brand_info品牌信息表

字段|名称|注释
--|:--:|--:
id|自增序列|主键，不做任何业务
brand_id|品牌id|
brand_name|品牌名称|
brand_des|品牌介绍|
img|品牌图片|

##good_base_info

字段|名称|注释
--|:--:|--:
ID|自增序列|
good_id|商品id|
good_name|商品名称|
good_type_id|商品类别id|
brand_id|商品品牌id|
good_price|商品价格|
screen_size|商品屏幕尺寸|
good_desc|商品简介|
seller_id|商家ID|
stock|当前库存|
sold|已售|
up_time|上架时间|
detail_table|详细信息表|
good_img|商品图片|

##computer

字段|名称|注释
--|:--:|--:
good_id|商品id|
computer_id|电脑id|
computer_name|电脑名称|
computer_version|版本|
computer_colour|颜色|
price|价格|
computer_img_url|图片|
computer_CPU|处理器型号|
computer_GPU|显卡型号|
computer_ROM|内存大小|
computer_RAM|存储容量|
computer_screen_size|屏幕尺寸|
computer_screen_resolution|屏幕分辨率|
computer_screen_refresh|刷新率|
material|材质|
system|系统|
weight|重量，体积|
brand_id|品牌id|
good_desc|简介|

##mobile_phone

字段|名称|注释
--|:--:|--:
商品id|good_id|
手机id|computer_id|
手机名称|computer_name|
版本|computer_version|
颜色|computer_colour|
价格|price|
图片|computer_img_url|
处理器型号|computer_CPU|
显卡型号|computer_GPU|
内存大小|computer_ROM|
存储容量|computer_RAM|
屏幕尺寸|computer_screen_size|
屏幕分辨率|computer_screen_resolution|
刷新率|computer_screen_refresh|
材质|material|
系统|system|
重量，体积|weight|
品牌id|brand_id|
简介|good_desc|
