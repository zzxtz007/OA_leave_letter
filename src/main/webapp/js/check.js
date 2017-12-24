function checkInput(input) {
    console.log(input.val());
    var reg = /^[a-zA-Z]{4}\w{0,11}$/;
    return reg.test(input.val());
}

// 登录消息顶框
var topErr = $('.top-err');

// 登录消息顶框下来后，重新返回
topErr.on('transitionend', function () {
    setTimeout(function () {
        topErr.css('height', '0');
    }, 1000);
});

function topErrMethod(color, message) {
    topErr.css('background', color);
    topErr.text(message);
    topErr.css('height', '100px');
}