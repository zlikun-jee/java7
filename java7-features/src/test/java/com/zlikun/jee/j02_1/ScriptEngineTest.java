package com.zlikun.jee.j02_1;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static org.junit.Assert.assertNotNull;

/**
 * 脚本引擎测试
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018/8/6 17:19
 */
public class ScriptEngineTest {

    @Test
    public void javascript() throws ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("JavaScript");
        ScriptEngine engine = manager.getEngineByExtension("js");
        assertNotNull(engine);
        engine.eval("println('Hello!')");

    }

    /**
     * 默认不支持Python脚本，需要引入Jython引擎
     * @throws ScriptException
     */
    @Test
    public void python() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByExtension("py");
        assertNotNull(engine);
        // Hello Python!
        engine.eval("print('Hello Python!')");
        // *
        // **
        // ***
        // ****
        // *****
        engine.eval("for i in range(5):\n    print('*' * (i + 1))");
    }

}
