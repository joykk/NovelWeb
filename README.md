# NovelWeb
小说网站的设计与实现
1、需求分析
角色分析：系统管理员、读者、作者、游客
功能分析：
角色	功能	
管理员	管理员登录 	
	读者管理 	查询、删除、启用、停用读者
	作者管理 	查询、删除、启用、停用作者
	小说管理 	查询、删除、下架、上架图书
读者	读者登录 	
	注册 	
	浏览小说 	
	查询小说	
	购买小说	
	阅读小说	
	我的订单	
作者	作者登录	
	作者注册	
	发布小说	
	管理章节	
游客	浏览小说	
	查询小说	
过滤器:字符过滤,登陆过滤  
网站访问人数  
2、数据库设计

表1  Author作者
列名	数据类型	允许Null值	默认值	备注	说明
AuthorID	int	否		主键，标识	自增长的ID
AuthorName	varchar(40)				作者名
UserName	varchar(20)	否			用户名
Password	varchar(32)	否			用户密码
Sex	varchar(20)				性别
Birthday	datetime				用户姓名
Status	varchar(20)			启用|停用	状态
LastLoginTime	datetime				最近一次登录时间

表2  Novel小说
列名	数据类型	允许Null值	默认值	备注	说明
NovelID	int	否		主键，标识	自增长的ID
NovelName	varchar(40)				小说名
Pic	varchar(40)	否			小说图片
Content	varchar(1000)	否			小说简介
Category	varchar(20)	否			小说类别
ClickCount	Int				点击量
Progress	varchar(20)			未完|完结	状态
WodCount	int				字数
Price	float				售价
AuthorID	Int				作者ID

表3  Chapter章节
列名	数据类型	允许Null值	默认值	备注	说明
ChapterID	int	否		主键，标识	自增长的ID
ChapterName	varchar(100)				章节名
ChapterContent	varchar(max)	否			章节内容
NovelID	int	否			小说ID

表4  Reader读者
列名	数据类型	允许Null值	默认值	备注	说明
ReaderID	int	否		主键，标识	自增长的ID
ReaderName	varchar(40)				读者名
NickName	varchar(40)				昵称
UserName	varchar(20)	否			用户名
Password	varchar(32)	否			用户密码
Sex	varchar(20)				性别
Birthday	datetime				生日
Status	varchar(20)			启用|停用	状态
LastLoginTime	datetime				最近一次登录时间

表5  ReaderLog阅读记录
列名	数据类型	允许Null值	默认值	备注	说明
ReaderLogID	int	否		主键，标识	自增长的ID
ReaderID	int	否			读者ID
 NovelID	int	否			小说ID
ChapterID	int	否			章节ID
ReaderTime	datetime				阅读时间

表6  ReaderOrder读者购书订单
列名	数据类型	允许Null值	默认值	备注	说明
ReaderOrderID	int	否		主键，标识	自增长的ID
ReaderID	int				读者ID
OrderDatetime	datetime	否			订单时间
OrderTotalPrice	float	否			订单价格
					
表7  ReaderOrderDetail读者购书订单细节
列名	数据类型	允许Null值	默认值	备注	说明
ReaderOrderDetailID	int	否		主键，标识	自增长的ID
ReaderOrderID	int				订单ID
 NovelID	int	否			小说ID
