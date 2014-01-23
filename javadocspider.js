var cheerio = require('cheerio');
var request = require('request');
var fs = require('co-fs');
var co = require('co');
var thunk = require('thunkify');
var get = thunk(request.get);
var redisClient = require('redis').createClient();
var wrapper = require('co-redis');
var redis = wrapper(redisClient);

redisClient.keys('*', function (err, keys) {
  if (err) return console.log(err);

  for(var i = 0, len = keys.length; i < len; i++) {
    //console.log(keys[i]);
  }
});


var indent = '';


co(function *() {
  var res = yield fs.readFile(__dirname+'/collectionInterface.html');
  var links = getImplementingClasses(res.toString());
  fetchSubclassLinks(links, 'implements java.util.Collection');
})();

function fetchSubclassLinks(links,parentName) {

  co(function* () {
    var data = links.map(function (link) {
      var url = 'http://docs.oracle.com/javase/7/docs/api/java/util/'+link;
      return {req: get(url), url: url};
    });

    (yield data).forEach(function (info) {
      co(function* () {
        var subclasses = getSubclasses(info.req.body);
        var thisName = storeClassInfo(info.req.body, parentName);
        fetchSubclassLinks(subclasses,thisName);
      })();
    });
  })();
}


function storeClassInfo (str, parentName) {
  $ = cheerio.load(str);
  var path = $('.header .subTitle').text();
  var classname = $('.header .title').text();
  classname = classname.substring('Class '.length,classname.length);
  path = path+'.'+classname;
  console.log(path + ' , ' + parentName)
  return path;
}

function getSubclasses (str) {
  $ = cheerio.load(str);
  var dl = $('.description ul li dl').filter(function (i , elem) {
    var a = $(elem);
    return (a.children().first().text() === 'Direct Known Subclasses:');
  });

  var dt = dl.children().eq(1);
  var links = [];
  dt.find('a').each(function(i, elem) {
    links.push($(elem).attr('href'));
  })
  //console.log(links);
  return links;  
}

function getImplementingClasses(str) {
  $ = cheerio.load(str);
  var dl = $('.description ul li dl').filter(function (i , elem) {
    var a = $(elem);
    return (a.children().first().text() === 'All Known Implementing Classes:');
  });

  var dt = dl.children().eq(1);
  var links = [];
  dt.find('a').each(function(i, elem) {
    links.push($(elem).attr('href'));
  })
  return links;
}
