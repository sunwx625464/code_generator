package ${package};

import java.io.Serializable;

/**
* <p>
* ${tableComment}
* </p>
*
* @author ${author}
* @since ${date}
*/
publicclass ${entityClass} implements Serializable {

privatestaticfinallong serialVersionUID = 1L;

<#--属性遍历-->
<#list columns as pro>

    /**
    * ${pro.comment}
    */
    private ${pro.propertyType} ${pro.propertyName};
</#list>

<#--属性get||set方法-->
<#list columns as pro>
    public ${pro.propertyType} get${pro.propertyName?cap_first}() {
        returnthis.${pro.propertyName};
    }

    public ${entityClass} set${pro.propertyName?cap_first}(${pro.propertyType} ${pro.propertyName}) {
        this.${pro.propertyName} = ${pro.propertyName};
        returnthis;
    }
</#list>
}