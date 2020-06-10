/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "./src/main.js");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./src/info.js":
/*!*********************!*\
  !*** ./src/info.img ***!
  \*********************/
/*! exports provided: name, age, height */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"name\", function() { return name; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"age\", function() { return age; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"height\", function() { return height; });\n// 这里采用ES6语法\r\nconst name = 'Robin';\r\nconst age = 18;\r\nconst height = 1.88;\r\n\n\n//# sourceURL=webpack:///./src/info.img?");

/***/ }),

/***/ "./src/main.js":
/*!*********************!*\
  !*** ./src/main.img ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _info__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./info */ \"./src/info.img\");\n//采用commonJS\r\nconst {add,mul} = __webpack_require__(/*! ./mathUtils.img */ \"./src/mathUtils.img\")\r\n\r\nconsole.log(add(2, 3));\r\nconsole.log(mul(30, 20));\r\n\r\n// 采用ES6\r\n\r\n\r\nconsole.log(_info__WEBPACK_IMPORTED_MODULE_0__[\"name\"]);\r\nconsole.log(_info__WEBPACK_IMPORTED_MODULE_0__[\"age\"]);\r\nconsole.log(_info__WEBPACK_IMPORTED_MODULE_0__[\"height\"]);\r\n\r\n\r\n//\r\n// webpack如果是3.xxx，打包命令是：\r\n//     webpack ./src/main.img  ./dist/bundle.img\r\n//\r\n//\r\n// 因为我们使用的webpack版本是4.xx的，所有打包命令是：\r\n//     npx webpack ./src/main.img -o ./dist/bundle.img\r\n//\r\n\r\n\r\n\n\n//# sourceURL=webpack:///./src/main.img?");

/***/ }),

/***/ "./src/mathUtils.js":
/*!**************************!*\
  !*** ./src/mathUtils.img ***!
  \**************************/
/*! no static exports found */
/***/ (function(module, exports) {

eval("function add(num1, num2) {\r\n    return num1 + num2;\r\n}\r\n\r\nfunction mul(num1, num2) {\r\n    return num1 * num2;\r\n}\r\n\r\n\r\n// commonJS方式导出\r\nmodule.exports = {\r\n    add,\r\n    mul\r\n}\r\n\n\n//# sourceURL=webpack:///./src/mathUtils.img?");

/***/ })

/******/ });
