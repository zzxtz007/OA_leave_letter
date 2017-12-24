/**
 * 登录时间
 * @param e 传入事件，用以取消submit默认的刷新网页
 */
function load(e) {
    e = e || window.event;
    e.preventDefault();
    if (userFlag === true && pwdFlag === true) {
        $.ajax({
            url: '../api/user/login',
            type: 'GET',
            data: {
                userName: $('.userName').val(),
                password: $('.password').val()
            }
        })
            .done(function (Response) {
                'use strict';
                switch (Response.status) {
                    case 0:
                        topErrMethod('#0f0', '登录成功');
                        setTimeout(function () {
                            location.href = '../main/main.html';
                        }, 1000);
                        break;
                    case 2:
                        topErrMethod('#f00', '别瞎传值');
                        break;
                }
            })
            .fail(function () {
                topErrMethod('#f00', '网络传输错误');
            });
    }
}


// 调用初始化方法
loginAddEvent();

// 用户/密码检查标志
var userFlag = false;
var pwdFlag = false;

// 给登录按钮绑定时间
$('.lgoin.btn-style').on('click', load);

/**
 * 错误信息，登录框抖动
 */
function errLoad() {
    var loadWin = $('.load');
    loadWin.animate({'left': '10'}, 50);
    loadWin.animate({'left': '-10'}, 50);
}

/**
 * 登陆框抖动函数
 */
function errStart() {
    for (var i = 0; i < 3; i++) {
        setTimeout(errLoad, 100);
    }
    var loadWin = $('.load');
    loadWin.animate({'left': '0'}, 50);
}

/**
 *  进入页面后初始化给user和pwd
 */
function loginAddEvent() {
    var user = $('.userName');
    var pwd = $('.password');

    user.on('blur', checkUserEvent);
    user.on('focus', clearErr);

    pwd.on('blur', checkPwdEvent);
    pwd.on('focus', clearErr);
}

/**
 * 检查用户名是否符合输入条件
 */
function checkUserEvent() {
    var user = $('.userName');
    if (user.val() === '' || user.val() === undefined || user.val() === null) {
        $('.err-msg').text('用户名不能为空');
        errStart();
        userFlag = false;
    } else if (checkInput(user) === false) {
        $('.err-msg').text('用户名输入错误');
        errStart();
        userFlag = false;
    } else {
        userFlag = true;
    }
}

/**
 * 检查密码是否符合条件
 */
function checkPwdEvent() {
    var pwd = $('.password');
    if (pwd.val() === '' || pwd.val() === undefined || pwd.val() === null) {
        $('.err-msg').text('密码不能为空');
        errStart();
        pwdFlag = false;
    } else if (pwd.val().length < 5) {
        $('.err-msg').text('密码不能长度不能小于5位');
        errStart();
        pwdFlag = false;
    } else {
        pwdFlag = true;
    }
}

/**
 * 清空错误提示框
 */
function clearErr() {
    $('.err-msg').text('');
}

