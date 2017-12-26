// 当前页面数量
var pageNum = 0;
// 页面总数量
var allPageNum = 0;
// 是否处理
var isComplete = 0;

// 侧边导航栏打开事件
$('.hidden-button').on('mouseover', openSide);

// 侧边导航栏关闭事件
$('.main').on('mousemove', function (e) {
    var xx = e.pageX;
    if (xx >= 300) {
        closeSide();
    }
});

// tab选项卡切换动作
$('#tab1').on('click', function () {
    $('#tab1').addClass('mdui-tab-active');
    $('#tab2').removeClass('mdui-tab-active');
    $('.mdui-tab-indicator').css('left', '23.8%');
});

$('#tab2').on('click', function () {
    $('#tab2').addClass('mdui-tab-active');
    $('#tab1').removeClass('mdui-tab-active');
    $('.mdui-tab-indicator').css('left', '50%');
});

// 打开侧边栏方法
function openSide() {
    $('.side-nav').css('left', '0');
}

// 关闭侧边栏方法
function closeSide() {
    $('.side-nav').css('left', '-300px');
}

/**
 * 查询页面信息
 * 获取请假条数
 */
function select() {
    $.ajax({
        url: 'leaveLetter/count',
        type: 'GET',
        data: {
            status: isComplete
        }
    })
        .done(function (Response) {
            'use strict';
            console.log(Response);
            switch (Response.status) {
                case 0:
                    addMessage(Response);
                    break;
                case 2:
                    topErrMethod('#f00', '别瞎传值');
                    break;
            }
        })
        .fail(function () {
            'use strict';
            topErrMethod('#f00', '网络异常，请稍后再试');
        });
}

/**
 * 将获取的数值传入table内
 * @param json 通过ajax获取到的json字符
 */
function addMessage(json) {
    var allMessageNum = json.count;
    var message = json.status;

    allPageNum = allMessageNum % 13 === 0 ? allMessageNum / 13 : allMessageNum / 13 + 1;

    var table = $('.mdui-table');

    table.html('');

    if (message.length === 0) {
        var noMessage = $('<tr>\n' +
            '            <td colspan="3">暂无请假信息</td>\n' +
            '            </tr>');
        table.append(noMessage);
    } else if (message.length >= 1) {
        loopAdd(message, table);
    }

    $('.page-tips').text('共有' + allMessageNum + '条数据,当前' + pageNum + '/' + allPageNum + '页');

}

/**
 * 循环遍历获得的数据
 * @param message 数据数组
 * @param table 要添加进去的table
 */
function loopAdd(message, table) {
    for (var user in message) {
        var tr = $('<tr><td>' + user.id + '</td><td>' + user.name + '</td><td>' +
            '<a class="a-style" value="' + user.id + '">' +
            '<i class="mdui-icon material-icons" ' +
            'mdui-tooltip="{content: \'详情\', position: \'top\'}">&#xe54b;</i></a>\n' +
            '</td></tr>');
        tr.on('click', function () {
            'use strict';
            $('.detail-message').css('display', 'block');
        });
        table.append(tr);
    }
}

// 关闭详细页面按钮
$('.mdui-btn.mdui-ripple.close').on('click', function () {
    $('.detail-message').css('display', 'none');
});

// 获取所有a标签
var pageBtns = $('.pick-page-td').find('a');

/**
 * 初始化
 */
addChangePage(pageBtns);

// 添加页面的按钮
function addChangePage(pageBtns) {
    // 首页按钮点击事件
    pageBtns.eq(0).on('click', function () {
        if (pageNum === 1) {
            topErrMethod('#ee0', '已经是第一页');
        } else {
            pageNum = 1;
            select();
        }
    });

    // 上一页点击按钮事件
    pageBtns.eq(1).on('click', function () {
        if (pageNum === 1) {
            topErrMethod('#ee0', '已经是第一页');
        } else {
            pageNum -= 1;
            select();
        }
    });
    // 下一页点击按钮事件
    pageBtns.eq(2).on('click', function () {
        if (pageNum === allPageNum) {
            topErrMethod('#ee0', '已经是最後页');
        } else {
            pageNum += 1;
            select();
        }
    });
    // 末页点击按钮事件
    pageBtns.eq(3).on('click', function () {
        if (pageNum === allPageNum) {
            topErrMethod('#ee0', '已经是最後页');
        } else {
            pageNum = allPageNum;
            select();
        }
    });
}

// 初始化
select();

// tab选项卡点击事件
$('#tab1').on('click', function () {
    pageNum = 1;
    isComplete = 0;
    select();
});
$('#tab2').on('click', function () {
    pageNum = 1;
    isComplete = 1;
    select();
});

// 点击提交
$('#up-btn').on('click', function () {
    var approved = $('#approve-checkbox')[0].checked;
    var feedBack = $('.mdui-textfield-input').val();
    $.ajax({
        url: '',
        type: 'POST',
        data: {
            approved: approved,
            feedBack: feedBack
        }
    })
        .done(function (Response) {
            'use strict';
            topErrMethod('#0F0', '提交成功');
        })
        .fail(function (Response) {
            'use strict';

        });
});