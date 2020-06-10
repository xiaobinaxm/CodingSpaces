import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})

/*
万能命令
javascript:(function () {
  window.open("https://wanneng.run/f/#" + document.location.href)
})()

彩云小译
javascript: void((function () {  if (!document.body) {    return  }  var popup = document.querySelectorAll('.cyxy-target-popup');  if (popup && popup.length > 0) {    return  }  try {    var trs = document.createElement('script');    trs.type = 'text/javascript';    trs.charset = 'UTF-8';    trs.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'caiyunapp.com/dest/trs.img';    document.body.appendChild(trs);  } catch (e) {    alert(e);  }  document.addEventListener('securitypolicyviolation', function handler(e) {    console.error('securitypolicyviolation', e);    alert('由于当前网站的内容安全策略(Content Security Policy)，小译无法启动翻译程序，您可以在Chrome商店搜索彩云小译（LingoCloud）扩展进行翻译');    document.removeEventListener('securitypolicyviolation', handler);  });})());

看视频加速
javascript: (function () { document.querySelector("video").playbackRate = 3.0 })()
javascript: (function () { document.querySelector("video").playbackRate = 2.0 })();

显示密码
javascript:"use strict";
!function () {
  var e, t;
  e = document.getElementsByTagName("input");
  for (var a = 0; a < e.length; a++) if (t = e[a], "password" == t.type.toLowerCase())
  try {
    t.type = "text"
  } catch (e) {
    var r, n;
    r = document.createElement("input"), n = t.attributes;
    for (var o = 0; o < n.length; o++) {
      var i, c, d;
      i = n[o], c = i.nodeName, d = i.nodeValue, "type" != c.toLowerCase() && "height" != c && "width" != c & !!d && (r[c] = d)
    }
    t.parentNode.replaceChild(r, t)
  }
}();




万能命令
javascript:(function(){window.open("https://wanneng.run/f/#"+document.location.href)})();

彩云小译
javascript: void((function () {  if (!document.body) {    return  }  var popup = document.querySelectorAll('.cyxy-target-popup');  if (popup && popup.length > 0) {    return  }  try {    var trs = document.createElement('script');    trs.type = 'text/javascript';    trs.charset = 'UTF-8';    trs.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'caiyunapp.com/dest/trs.img';    document.body.appendChild(trs);  } catch (e) {    alert(e);  }  document.addEventListener('securitypolicyviolation', function handler(e) {    console.error('securitypolicyviolation', e);    alert('由于当前网站的内容安全策略(Content Security Policy)，小译无法启动翻译程序，您可以在Chrome商店搜索彩云小译（LingoCloud）扩展进行翻译');    document.removeEventListener('securitypolicyviolation', handler);  });})());

看视频加速
javascript: (function () { document.querySelector("video").playbackRate = 3.0 })();
javascript: (function () { document.querySelector("video").playbackRate = 2.0 })();

显示密码
javascript:"use strict";!function(){var e,t;e=document.getElementsByTagName("input");for(var a=0;a<e.length;a++)if(t=e[a],"password"==t.type.toLowerCase())try{t.type="text"}catch(e){var r,n;r=document.createElement("input"),n=t.attributes;for(var o=0;o<n.length;o++){var i,c,d;i=n[o],c=i.nodeName,d=i.nodeValue,"type"!=c.toLowerCase()&&"height"!=c&&"width"!=c&!!d&&(r[c]=d)}t.parentNode.replaceChild(r,t)}}();
*/
