# Tollgate

本项目为事件驱动的微服务系统设计演示之用。系统架构如下：

![](architecture.png)


## 车辆状态机模型

```xml
<?xml version="1.0"?>
<scxml xmlns="http://www.w3.org/2005/07/scxml" version="1.0" initial="approached">

    <state id="approached">
        <transition event="start" target="recognizing"/>
    </state>

    <state id="recognizing">
        <transition event="recognition_fails" target="approached"/>
        <transition event="recognition_successes" target="recognized"/>
    </state>

    <state id="recognized">
        <transition event="validation_starts" target="validating"/>
    </state>

    <state id="validating">
        <transition event="validation_fails" target="recognized"/>
        <transition event="validation_successes." target="validated"/>
    </state>

    <state id="validated">
        <transition event="billing_starts" target="billing"/>
    </state>

    <state id="billing">
        <transition event="billing_fails" target="validated"/>
        <transition event="billing_successes" target="billed"/>
    </state>

    <state id="billed">
        <transition event="pay" target="paid"/>
    </state>

    <state id="paid">
        <transition event="leaving_detects" target="left"/>
    </state>

    <final id="left"/>

</scxml>
```