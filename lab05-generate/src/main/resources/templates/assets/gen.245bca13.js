import{C as t}from"./index.a838d319.js";function o(e){return t({headers:{datasource:localStorage.getItem("dataName")},url:"/tool/gen/list",method:"get",params:e})}function r(e){return t({headers:{datasource:localStorage.getItem("dataName")},url:"/tool/gen/db/list",method:"get",params:e})}function l(e){return t({headers:{datasource:localStorage.getItem("dataName")},url:"/tool/gen/"+e,method:"get"})}function d(e){return t({headers:{datasource:localStorage.getItem("dataName")},url:"/tool/gen",method:"put",data:e})}function n(e){return t({headers:{datasource:localStorage.getItem("dataName")},url:"/tool/gen/importTable",method:"post",params:e})}function s(e){return t({headers:{datasource:localStorage.getItem("dataName")},url:"/tool/gen/preview/"+e,method:"get"})}function u(e){return t({headers:{datasource:localStorage.getItem("dataName")},url:"/tool/gen/"+e,method:"delete"})}function g(e){return t({headers:{datasource:localStorage.getItem("dataName")},url:"/tool/gen/genCode/"+e,method:"get"})}function m(e){return t({headers:{datasource:localStorage.getItem("dataName")},url:"/tool/gen/synchDb/"+e,method:"get"})}export{o as a,l as b,u as d,g,n as i,r as l,s as p,m as s,d as u};
