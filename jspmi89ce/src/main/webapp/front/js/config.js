
var projectName = '高校人事管理系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.jsp'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.jsp'
},

]


var indexNav = [

{
	name: '考勤打卡',
	url: './pages/kaoqindaka/list.jsp'
}, 

{
	name: '论坛信息',
	url: './pages/forum/list.jsp'
}, 
]

var adminurl =  "http://localhost:8080/jspmi89ce/index.jsp";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"buttons":["查看","修改","删除"],"menu":"员工","menuJump":"列表","tableName":"yuangong"}],"menu":"员工管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"系统公告","menuJump":"列表","tableName":"xitonggonggao"}],"menu":"系统公告管理"},{"child":[{"buttons":["查看","删除","修改"],"menu":"考勤打卡","menuJump":"列表","tableName":"kaoqindaka"}],"menu":"考勤打卡管理"},{"child":[{"buttons":["查看","修改","删除","审核"],"menu":"请假信息","menuJump":"列表","tableName":"qingjiaxinxi"}],"menu":"请假信息管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"年假信息","menuJump":"列表","tableName":"nianjiaxinxi"}],"menu":"年假信息管理"},{"child":[{"buttons":["查看","修改","删除","审核"],"menu":"年假调休","menuJump":"列表","tableName":"nianjiadiaoxiu"}],"menu":"年假调休管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"工资信息","menuJump":"列表","tableName":"gongzixinxi"}],"menu":"工资信息管理"},{"child":[{"buttons":["查看","删除","修改"],"menu":"论坛管理","tableName":"luntanguanli"}],"menu":"论坛管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"lunbotuguanli"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["新增","查看"],"menu":"考勤打卡列表","menuJump":"列表","tableName":"kaoqindaka"}],"menu":"考勤打卡模块"}],"roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"请假信息","menuJump":"列表","tableName":"qingjiaxinxi"}],"menu":"请假信息管理"},{"child":[{"buttons":["查看","调休申请"],"menu":"年假信息","menuJump":"列表","tableName":"nianjiaxinxi"}],"menu":"年假信息管理"},{"child":[{"buttons":["查看"],"menu":"年假调休","menuJump":"列表","tableName":"nianjiadiaoxiu"}],"menu":"年假调休管理"},{"child":[{"buttons":["查看"],"menu":"工资信息","menuJump":"列表","tableName":"gongzixinxi"}],"menu":"工资信息管理"},{"child":[{"buttons":["查看","删除"],"menu":"论坛管理","tableName":"luntanguanli"}],"menu":"论坛管理"}],"frontMenu":[{"child":[{"buttons":["新增","查看"],"menu":"考勤打卡列表","menuJump":"列表","tableName":"kaoqindaka"}],"menu":"考勤打卡模块"}],"roleName":"员工","tableName":"yuangong"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
