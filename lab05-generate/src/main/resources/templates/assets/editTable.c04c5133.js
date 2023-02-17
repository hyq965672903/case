import{h as k,r as d,o as c,j as T,w as l,d as e,u as w,C as R,D as Q,f as p,E as O,a as q,F,l as W,A as j,v as H,b as P,n as G,q as K,z as J,t as A,m as X}from"./index.92c7fc6b.js";import{b as Y,u as Z}from"./gen.738a6c89.js";const ee={__name:"basicInfoForm",props:{info:{type:Object,default:null}},setup(a){const g=k({tableName:[{required:!0,message:"\u8BF7\u8F93\u5165\u8868\u540D\u79F0",trigger:"blur"}],tableComment:[{required:!0,message:"\u8BF7\u8F93\u5165\u8868\u63CF\u8FF0",trigger:"blur"}],className:[{required:!0,message:"\u8BF7\u8F93\u5165\u5B9E\u4F53\u7C7B\u540D\u79F0",trigger:"blur"}],functionAuthor:[{required:!0,message:"\u8BF7\u8F93\u5165\u4F5C\u8005",trigger:"blur"}]});return(I,V)=>{const x=d("el-input"),h=d("el-form-item"),N=d("el-col"),$=d("el-row"),y=d("el-form");return c(),T(y,{ref:"basicInfoForm",model:a.info,rules:w(g),"label-width":"150px"},{default:l(()=>[e($,null,{default:l(()=>[e(N,{span:12},{default:l(()=>[e(h,{label:"\u8868\u540D\u79F0",prop:"tableName"},{default:l(()=>[e(x,{placeholder:"\u8BF7\u8F93\u5165\u4ED3\u5E93\u540D\u79F0",modelValue:a.info.tableName,"onUpdate:modelValue":V[0]||(V[0]=v=>a.info.tableName=v)},null,8,["modelValue"])]),_:1})]),_:1}),e(N,{span:12},{default:l(()=>[e(h,{label:"\u8868\u63CF\u8FF0",prop:"tableComment"},{default:l(()=>[e(x,{placeholder:"\u8BF7\u8F93\u5165",modelValue:a.info.tableComment,"onUpdate:modelValue":V[1]||(V[1]=v=>a.info.tableComment=v)},null,8,["modelValue"])]),_:1})]),_:1}),e(N,{span:12},{default:l(()=>[e(h,{label:"\u5B9E\u4F53\u7C7B\u540D\u79F0",prop:"className"},{default:l(()=>[e(x,{placeholder:"\u8BF7\u8F93\u5165",modelValue:a.info.className,"onUpdate:modelValue":V[2]||(V[2]=v=>a.info.className=v)},null,8,["modelValue"])]),_:1})]),_:1}),e(N,{span:12},{default:l(()=>[e(h,{label:"\u4F5C\u8005",prop:"functionAuthor"},{default:l(()=>[e(x,{placeholder:"\u8BF7\u8F93\u5165",modelValue:a.info.functionAuthor,"onUpdate:modelValue":V[3]||(V[3]=v=>a.info.functionAuthor=v)},null,8,["modelValue"])]),_:1})]),_:1}),e(N,{span:24},{default:l(()=>[e(h,{label:"\u5907\u6CE8",prop:"remark"},{default:l(()=>[e(x,{type:"textarea",rows:3,modelValue:a.info.remark,"onUpdate:modelValue":V[4]||(V[4]=v=>a.info.remark=v)},null,8,["modelValue"])]),_:1})]),_:1})]),_:1})]),_:1},8,["model","rules"])}}};function le(){return R({url:"/system/dict/type/optionselect",method:"get"})}function ae(a){return R({url:"/system/menu/list",method:"get",params:a})}const te=P("i",{class:"el-icon-arrow-down el-icon--right"},null,-1),ne=P("h4",{class:"form-header"},"\u5176\u4ED6\u4FE1\u606F",-1),oe=P("h4",{class:"form-header"},"\u5173\u8054\u4FE1\u606F",-1),ue={__name:"genInfoForm",props:{info:{type:Object,default:null},tables:{type:Array,default:null}},setup(a){const g=a,I=k([]),V=k([]),{proxy:x}=G(),h=k({tplCategory:[{required:!0,message:"\u8BF7\u9009\u62E9\u751F\u6210\u6A21\u677F",trigger:"blur"}],packageName:[{required:!0,message:"\u8BF7\u8F93\u5165\u751F\u6210\u5305\u8DEF\u5F84",trigger:"blur"}],moduleName:[{required:!0,message:"\u8BF7\u8F93\u5165\u751F\u6210\u6A21\u5757\u540D",trigger:"blur"}],businessName:[{required:!0,message:"\u8BF7\u8F93\u5165\u751F\u6210\u4E1A\u52A1\u540D",trigger:"blur"}],functionName:[{required:!0,message:"\u8BF7\u8F93\u5165\u751F\u6210\u529F\u80FD\u540D",trigger:"blur"}]});function N(U){g.info.subTableFkName=""}function $(U){U!=="sub"&&(g.info.subTableName="",g.info.subTableFkName="")}function y(U){for(var u in g.tables){const b=g.tables[u].tableName;if(U===b){I.value=g.tables[u].columns;break}}}function v(){ae().then(U=>{V.value=x.handleTree(U.data,"menuId")})}return Q(()=>g.info.subTableName,U=>{y(U)}),v(),(U,u)=>{const b=d("el-option"),i=d("el-select"),f=d("el-form-item"),r=d("el-col"),s=d("question-filled"),n=d("el-icon"),_=d("el-tooltip"),C=d("el-input"),L=d("tree-select"),B=d("el-radio"),D=d("el-button"),S=d("el-dropdown-item"),M=d("el-dropdown-menu"),o=d("el-dropdown"),m=d("el-row"),z=d("el-form");return c(),T(z,{ref:"genInfoForm",model:a.info,rules:w(h),"label-width":"150px"},{default:l(()=>[e(m,null,{default:l(()=>[e(r,{span:12},{default:l(()=>[e(f,{prop:"tplCategory"},{label:l(()=>[p("\u751F\u6210\u6A21\u677F")]),default:l(()=>[e(i,{modelValue:a.info.tplCategory,"onUpdate:modelValue":u[0]||(u[0]=t=>a.info.tplCategory=t),onChange:$},{default:l(()=>[e(b,{label:"\u5355\u8868\uFF08\u589E\u5220\u6539\u67E5\uFF09",value:"crud"}),e(b,{label:"\u6811\u8868\uFF08\u589E\u5220\u6539\u67E5\uFF09",value:"tree"})]),_:1},8,["modelValue"])]),_:1})]),_:1}),e(r,{span:12},{default:l(()=>[e(f,{prop:"packageName"},{label:l(()=>[p(" \u751F\u6210\u5305\u8DEF\u5F84 "),e(_,{content:"\u751F\u6210\u5728\u54EA\u4E2Ajava\u5305\u4E0B\uFF0C\u4F8B\u5982 com.ruoyi.system",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(C,{modelValue:a.info.packageName,"onUpdate:modelValue":u[1]||(u[1]=t=>a.info.packageName=t)},null,8,["modelValue"])]),_:1})]),_:1}),e(r,{span:12},{default:l(()=>[e(f,{prop:"moduleName"},{label:l(()=>[p(" \u751F\u6210\u6A21\u5757\u540D "),e(_,{content:"\u53EF\u7406\u89E3\u4E3A\u5B50\u7CFB\u7EDF\u540D\uFF0C\u4F8B\u5982 system",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(C,{modelValue:a.info.moduleName,"onUpdate:modelValue":u[2]||(u[2]=t=>a.info.moduleName=t)},null,8,["modelValue"])]),_:1})]),_:1}),e(r,{span:12},{default:l(()=>[e(f,{prop:"businessName"},{label:l(()=>[p(" \u751F\u6210\u4E1A\u52A1\u540D "),e(_,{content:"\u53EF\u7406\u89E3\u4E3A\u529F\u80FD\u82F1\u6587\u540D\uFF0C\u4F8B\u5982 user",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(C,{modelValue:a.info.businessName,"onUpdate:modelValue":u[3]||(u[3]=t=>a.info.businessName=t)},null,8,["modelValue"])]),_:1})]),_:1}),e(r,{span:12},{default:l(()=>[e(f,{prop:"functionName"},{label:l(()=>[p(" \u751F\u6210\u529F\u80FD\u540D "),e(_,{content:"\u7528\u4F5C\u7C7B\u63CF\u8FF0\uFF0C\u4F8B\u5982 \u7528\u6237",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(C,{modelValue:a.info.functionName,"onUpdate:modelValue":u[4]||(u[4]=t=>a.info.functionName=t)},null,8,["modelValue"])]),_:1})]),_:1}),e(r,{span:12},{default:l(()=>[e(f,null,{label:l(()=>[p(" \u4E0A\u7EA7\u83DC\u5355 "),e(_,{content:"\u5206\u914D\u5230\u6307\u5B9A\u83DC\u5355\u4E0B\uFF0C\u4F8B\u5982 \u7CFB\u7EDF\u7BA1\u7406",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(L,{value:a.info.parentMenuId,"onUpdate:value":u[5]||(u[5]=t=>a.info.parentMenuId=t),options:w(V),objMap:{value:"menuId",label:"menuName",children:"children"},placeholder:"\u8BF7\u9009\u62E9\u7CFB\u7EDF\u83DC\u5355"},null,8,["value","options"])]),_:1})]),_:1}),e(r,{span:12},{default:l(()=>[e(f,{prop:"genType"},{label:l(()=>[p(" \u751F\u6210\u4EE3\u7801\u65B9\u5F0F "),e(_,{content:"\u9ED8\u8BA4\u4E3Azip\u538B\u7F29\u5305\u4E0B\u8F7D\uFF0C\u4E5F\u53EF\u4EE5\u81EA\u5B9A\u4E49\u751F\u6210\u8DEF\u5F84",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(B,{modelValue:a.info.genType,"onUpdate:modelValue":u[6]||(u[6]=t=>a.info.genType=t),label:"0"},{default:l(()=>[p("zip\u538B\u7F29\u5305")]),_:1},8,["modelValue"]),e(B,{modelValue:a.info.genType,"onUpdate:modelValue":u[7]||(u[7]=t=>a.info.genType=t),label:"1"},{default:l(()=>[p("\u81EA\u5B9A\u4E49\u8DEF\u5F84")]),_:1},8,["modelValue"])]),_:1})]),_:1}),a.info.genType=="1"?(c(),T(r,{key:0,span:24},{default:l(()=>[e(f,{prop:"genPath"},{label:l(()=>[p(" \u81EA\u5B9A\u4E49\u8DEF\u5F84 "),e(_,{content:"\u586B\u5199\u78C1\u76D8\u7EDD\u5BF9\u8DEF\u5F84\uFF0C\u82E5\u4E0D\u586B\u5199\uFF0C\u5219\u751F\u6210\u5230\u5F53\u524DWeb\u9879\u76EE\u4E0B",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(C,{modelValue:a.info.genPath,"onUpdate:modelValue":u[9]||(u[9]=t=>a.info.genPath=t)},{append:l(()=>[e(o,null,{dropdown:l(()=>[e(M,null,{default:l(()=>[e(S,{onClick:u[8]||(u[8]=t=>a.info.genPath="/")},{default:l(()=>[p("\u6062\u590D\u9ED8\u8BA4\u7684\u751F\u6210\u57FA\u7840\u8DEF\u5F84")]),_:1})]),_:1})]),default:l(()=>[e(D,{type:"primary"},{default:l(()=>[p(" \u6700\u8FD1\u8DEF\u5F84\u5FEB\u901F\u9009\u62E9 "),te]),_:1})]),_:1})]),_:1},8,["modelValue"])]),_:1})]),_:1})):O("",!0)]),_:1}),a.info.tplCategory=="tree"?(c(),q(F,{key:0},[ne,W(e(m,null,{default:l(()=>[e(r,{span:12},{default:l(()=>[e(f,null,{label:l(()=>[p(" \u6811\u7F16\u7801\u5B57\u6BB5 "),e(_,{content:"\u6811\u663E\u793A\u7684\u7F16\u7801\u5B57\u6BB5\u540D\uFF0C \u5982\uFF1Adept_id",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(i,{modelValue:a.info.treeCode,"onUpdate:modelValue":u[10]||(u[10]=t=>a.info.treeCode=t),placeholder:"\u8BF7\u9009\u62E9"},{default:l(()=>[(c(!0),q(F,null,j(a.info.columns,(t,E)=>(c(),T(b,{key:E,label:t.columnName+"\uFF1A"+t.columnComment,value:t.columnName},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1})]),_:1}),e(r,{span:12},{default:l(()=>[e(f,null,{label:l(()=>[p(" \u6811\u7236\u7F16\u7801\u5B57\u6BB5 "),e(_,{content:"\u6811\u663E\u793A\u7684\u7236\u7F16\u7801\u5B57\u6BB5\u540D\uFF0C \u5982\uFF1Aparent_Id",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(i,{modelValue:a.info.treeParentCode,"onUpdate:modelValue":u[11]||(u[11]=t=>a.info.treeParentCode=t),placeholder:"\u8BF7\u9009\u62E9"},{default:l(()=>[(c(!0),q(F,null,j(a.info.columns,(t,E)=>(c(),T(b,{key:E,label:t.columnName+"\uFF1A"+t.columnComment,value:t.columnName},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1})]),_:1}),e(r,{span:12},{default:l(()=>[e(f,null,{label:l(()=>[p(" \u6811\u540D\u79F0\u5B57\u6BB5 "),e(_,{content:"\u6811\u8282\u70B9\u7684\u663E\u793A\u540D\u79F0\u5B57\u6BB5\u540D\uFF0C \u5982\uFF1Adept_name",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(i,{modelValue:a.info.treeName,"onUpdate:modelValue":u[12]||(u[12]=t=>a.info.treeName=t),placeholder:"\u8BF7\u9009\u62E9"},{default:l(()=>[(c(!0),q(F,null,j(a.info.columns,(t,E)=>(c(),T(b,{key:E,label:t.columnName+"\uFF1A"+t.columnComment,value:t.columnName},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1})]),_:1})]),_:1},512),[[H,a.info.tplCategory=="tree"]])],64)):O("",!0),a.info.tplCategory=="sub"?(c(),q(F,{key:1},[oe,e(m,null,{default:l(()=>[e(r,{span:12},{default:l(()=>[e(f,null,{label:l(()=>[p(" \u5173\u8054\u5B50\u8868\u7684\u8868\u540D "),e(_,{content:"\u5173\u8054\u5B50\u8868\u7684\u8868\u540D\uFF0C \u5982\uFF1Asys_user",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(i,{modelValue:a.info.subTableName,"onUpdate:modelValue":u[13]||(u[13]=t=>a.info.subTableName=t),placeholder:"\u8BF7\u9009\u62E9",onChange:N},{default:l(()=>[(c(!0),q(F,null,j(a.tables,(t,E)=>(c(),T(b,{key:E,label:t.tableName+"\uFF1A"+t.tableComment,value:t.tableName},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1})]),_:1}),e(r,{span:12},{default:l(()=>[e(f,null,{label:l(()=>[p(" \u5B50\u8868\u5173\u8054\u7684\u5916\u952E\u540D "),e(_,{content:"\u5B50\u8868\u5173\u8054\u7684\u5916\u952E\u540D\uFF0C \u5982\uFF1Auser_id",placement:"top"},{default:l(()=>[e(n,null,{default:l(()=>[e(s)]),_:1})]),_:1})]),default:l(()=>[e(i,{modelValue:a.info.subTableFkName,"onUpdate:modelValue":u[14]||(u[14]=t=>a.info.subTableFkName=t),placeholder:"\u8BF7\u9009\u62E9"},{default:l(()=>[(c(!0),q(F,null,j(w(I),(t,E)=>(c(),T(b,{key:E,label:t.columnName+"\uFF1A"+t.columnComment,value:t.columnName},null,8,["label","value"]))),128))]),_:1},8,["modelValue"])]),_:1})]),_:1})]),_:1})],64)):O("",!0)]),_:1},8,["model","rules"])}}},de={style:{float:"left"}},me={style:{float:"right",color:"#8492a6","font-size":"13px"}},re={style:{"text-align":"center","margin-left":"-100px","margin-top":"10px"}},ie=K({name:"GenEdit"}),be=Object.assign(ie,{setup(a){const g=J(),{proxy:I}=G(),V=k("columnInfo"),x=k(document.documentElement.scrollHeight-245+"px"),h=k([]),N=k([]),$=k([]),y=k({});function v(){const b=I.$refs.basicInfo.$refs.basicInfoForm,i=I.$refs.genInfo.$refs.genInfoForm;Promise.all([b,i].map(U)).then(f=>{if(f.every(s=>!!s)){const s=Object.assign({},y.value);s.columns=N.value,s.params={treeCode:y.value.treeCode,treeName:y.value.treeName,treeParentCode:y.value.treeParentCode,parentMenuId:y.value.parentMenuId},Z(s).then(n=>{I.$modal.msgSuccess(n.msg),n.code===200&&u()})}else I.$modal.msgError("\u8868\u5355\u6821\u9A8C\u672A\u901A\u8FC7\uFF0C\u8BF7\u91CD\u65B0\u68C0\u67E5\u63D0\u4EA4\u5185\u5BB9")})}function U(b){return new Promise(i=>{b.validate(f=>{i(f)})})}function u(){const b={path:"/tools/codegen",query:{t:Date.now(),pageNum:g.query.pageNum}};I.$tab.closeOpenPage(b)}return(()=>{const b=g.params&&g.params.tableId;b&&(Y(b).then(i=>{N.value=i.data.rows,y.value=i.data.info,h.value=i.data.tables}),le().then(i=>{$.value=i.data}))})(),(b,i)=>{const f=d("el-tab-pane"),r=d("el-table-column"),s=d("el-input"),n=d("el-option"),_=d("el-select"),C=d("el-checkbox"),L=d("el-table"),B=d("el-tabs"),D=d("el-button"),S=d("el-form"),M=d("el-card");return c(),T(M,null,{default:l(()=>[e(B,{modelValue:w(V),"onUpdate:modelValue":i[0]||(i[0]=o=>X(V)?V.value=o:null)},{default:l(()=>[e(f,{label:"\u57FA\u672C\u4FE1\u606F",name:"basic"},{default:l(()=>[e(w(ee),{ref:"basicInfo",info:w(y)},null,8,["info"])]),_:1}),e(f,{label:"\u5B57\u6BB5\u4FE1\u606F",name:"columnInfo"},{default:l(()=>[e(L,{ref:"dragTable",data:w(N),"row-key":"columnId","max-height":w(x)},{default:l(()=>[e(r,{label:"\u5E8F\u53F7",type:"index","min-width":"5%"}),e(r,{label:"\u5B57\u6BB5\u5217\u540D",prop:"columnName","min-width":"10%","show-overflow-tooltip":!0}),e(r,{label:"\u5B57\u6BB5\u63CF\u8FF0","min-width":"10%"},{default:l(o=>[e(s,{modelValue:o.row.columnComment,"onUpdate:modelValue":m=>o.row.columnComment=m},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),e(r,{label:"\u7269\u7406\u7C7B\u578B",prop:"columnType","min-width":"10%","show-overflow-tooltip":!0}),e(r,{label:"Java\u7C7B\u578B","min-width":"11%"},{default:l(o=>[e(_,{modelValue:o.row.javaType,"onUpdate:modelValue":m=>o.row.javaType=m},{default:l(()=>[e(n,{label:"Long",value:"Long"}),e(n,{label:"String",value:"String"}),e(n,{label:"Integer",value:"Integer"}),e(n,{label:"Double",value:"Double"}),e(n,{label:"BigDecimal",value:"BigDecimal"}),e(n,{label:"Date",value:"Date"}),e(n,{label:"Boolean",value:"Boolean"})]),_:2},1032,["modelValue","onUpdate:modelValue"])]),_:1}),e(r,{label:"java\u5C5E\u6027","min-width":"10%"},{default:l(o=>[e(s,{modelValue:o.row.javaField,"onUpdate:modelValue":m=>o.row.javaField=m},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),e(r,{label:"\u63D2\u5165","min-width":"5%"},{default:l(o=>[e(C,{"true-label":"1","false-label":"0",modelValue:o.row.isInsert,"onUpdate:modelValue":m=>o.row.isInsert=m},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),e(r,{label:"\u7F16\u8F91","min-width":"5%"},{default:l(o=>[e(C,{"true-label":"1","false-label":"0",modelValue:o.row.isEdit,"onUpdate:modelValue":m=>o.row.isEdit=m},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),e(r,{label:"\u5217\u8868","min-width":"5%"},{default:l(o=>[e(C,{"true-label":"1","false-label":"0",modelValue:o.row.isList,"onUpdate:modelValue":m=>o.row.isList=m},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),e(r,{label:"\u67E5\u8BE2","min-width":"5%"},{default:l(o=>[e(C,{"true-label":"1","false-label":"0",modelValue:o.row.isQuery,"onUpdate:modelValue":m=>o.row.isQuery=m},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),e(r,{label:"\u67E5\u8BE2\u65B9\u5F0F","min-width":"10%"},{default:l(o=>[e(_,{modelValue:o.row.queryType,"onUpdate:modelValue":m=>o.row.queryType=m},{default:l(()=>[e(n,{label:"=",value:"EQ"}),e(n,{label:"!=",value:"NE"}),e(n,{label:">",value:"GT"}),e(n,{label:">=",value:"GE"}),e(n,{label:"<",value:"LT"}),e(n,{label:"<=",value:"LE"}),e(n,{label:"LIKE",value:"LIKE"}),e(n,{label:"BETWEEN",value:"BETWEEN"})]),_:2},1032,["modelValue","onUpdate:modelValue"])]),_:1}),e(r,{label:"\u5FC5\u586B","min-width":"5%"},{default:l(o=>[e(C,{"true-label":"1","false-label":"0",modelValue:o.row.isRequired,"onUpdate:modelValue":m=>o.row.isRequired=m},null,8,["modelValue","onUpdate:modelValue"])]),_:1}),e(r,{label:"\u663E\u793A\u7C7B\u578B","min-width":"12%"},{default:l(o=>[e(_,{modelValue:o.row.htmlType,"onUpdate:modelValue":m=>o.row.htmlType=m},{default:l(()=>[e(n,{label:"\u6587\u672C\u6846",value:"input"}),e(n,{label:"\u6587\u672C\u57DF",value:"textarea"}),e(n,{label:"\u4E0B\u62C9\u6846",value:"select"}),e(n,{label:"\u5355\u9009\u6846",value:"radio"}),e(n,{label:"\u590D\u9009\u6846",value:"checkbox"}),e(n,{label:"\u65E5\u671F\u63A7\u4EF6",value:"datetime"}),e(n,{label:"\u56FE\u7247\u4E0A\u4F20",value:"imageUpload"}),e(n,{label:"\u6587\u4EF6\u4E0A\u4F20",value:"fileUpload"}),e(n,{label:"\u5BCC\u6587\u672C\u63A7\u4EF6",value:"editor"})]),_:2},1032,["modelValue","onUpdate:modelValue"])]),_:1}),e(r,{label:"\u5B57\u5178\u7C7B\u578B","min-width":"12%"},{default:l(o=>[e(_,{modelValue:o.row.dictType,"onUpdate:modelValue":m=>o.row.dictType=m,clearable:"",filterable:"",placeholder:"\u8BF7\u9009\u62E9"},{default:l(()=>[(c(!0),q(F,null,j(w($),m=>(c(),T(n,{key:m.dictType,label:m.dictName,value:m.dictType},{default:l(()=>[P("span",de,A(m.dictName),1),P("span",me,A(m.dictType),1)]),_:2},1032,["label","value"]))),128))]),_:2},1032,["modelValue","onUpdate:modelValue"])]),_:1})]),_:1},8,["data","max-height"])]),_:1}),e(f,{label:"\u751F\u6210\u4FE1\u606F",name:"genInfo"},{default:l(()=>[e(w(ue),{ref:"genInfo",info:w(y),tables:w(h)},null,8,["info","tables"])]),_:1})]),_:1},8,["modelValue"]),e(S,{"label-width":"100px"},{default:l(()=>[P("div",re,[e(D,{type:"primary",onClick:i[1]||(i[1]=o=>v())},{default:l(()=>[p("\u63D0\u4EA4")]),_:1}),e(D,{onClick:i[2]||(i[2]=o=>u())},{default:l(()=>[p("\u8FD4\u56DE")]),_:1})])]),_:1})]),_:1})}}});export{be as default};
