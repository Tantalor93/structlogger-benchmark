/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package cz.muni.fi;

import com.example.SimpleLogger;
import cz.muni.fi.annotation.VarContext;
import org.ngmon.structlog.StructLog;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

    @VarContext(context = DefaultContext.class)
    private static StructLogger<DefaultContext> structLogger = StructLogger.instance();

    private static Logger logger = LoggerFactory.getLogger("MyBenchmark");

    @Benchmark
    public void structLoggerBenchmark1Call() {
        structLogger.info("test {} string literal {}")
                .varDouble(1.2)
                .varBoolean(false)
                .log();
    }

    @Benchmark
    public void slf4jLoggerBenchmark1Call() {
        logger.info("test {} string literal {}", 1.2, false);
    }

    @Benchmark
    public void ngmonStructLoggerBenchmark1Call() throws Exception {
        StructLog<MyContext> LOGX = new StructLog<>(MyContext.class, new SimpleLogger());

        LOGX.info("test {} string literal {}")
                .varDouble(1.2)
                .varBoolean(false)
                .log();
    }

    @Benchmark
    public void structLoggerBenchmark8Calls() {
        make8StructLoggerCalls();
    }

    @Benchmark
    public void slf4jLoggerBenchmark8Calls() {
        make8Slf4jLogCalls();
    }

    @Benchmark
    public void ngmonStructLoggerBenchmark8Calls() throws Exception {
        make8NgmonStructLogCalls();
    }

    @Benchmark
    public void structLoggerBenchmark16Calls() {
        make8StructLoggerCalls();
        make8StructLoggerCalls();
    }

    @Benchmark
    public void slf4jLoggerBenchmark16Calls() {
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
    }

    @Benchmark
    public void ngmonStructLoggerBenchmark16Calls() throws Exception {
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
    }

    @Benchmark
    public void structLoggerBenchmark32Calls() {
        make8StructLoggerCalls();
        make8StructLoggerCalls();
        make8StructLoggerCalls();
        make8StructLoggerCalls();
    }

    @Benchmark
    public void slf4jLoggerBenchmark32Calls() {
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
    }

    @Benchmark
    public void ngmonStructLoggerBenchmark32Calls() throws Exception {
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
    }

    @Benchmark
    public void structLoggerBenchmark64Calls() {
        make8StructLoggerCalls();
        make8StructLoggerCalls();
        make8StructLoggerCalls();
        make8StructLoggerCalls();
        make8StructLoggerCalls();
        make8StructLoggerCalls();
        make8StructLoggerCalls();
        make8StructLoggerCalls();
    }

    @Benchmark
    public void slf4jLoggerBenchmark64Calls() {
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
        make8Slf4jLogCalls();
    }

    @Benchmark
    public void ngmonStructLoggerBenchmark64Calls() throws Exception {
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
        make8NgmonStructLogCalls();
    }

    @Benchmark
    public void structLoggerBenchmark128Calls() {
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
        this.make8StructLoggerCalls();
    }

    @Benchmark
    public void slf4jLoggerBenchmark128Calls() {
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
        this.make8Slf4jLogCalls();
    }

    @Benchmark
    public void ngmonStructLoggerBenchmark128Calls() throws Exception {
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
        this.make8NgmonStructLogCalls();
    }

    private void make8StructLoggerCalls() {
        structLogger.info("test {} string literal {}")
                .varDouble(1.2)
                .varBoolean(false)
                .log();

        structLogger.info("test {}")
                .varInt(1)
                .log();

        structLogger.info("test {} string literal {} for {}")
                .varDouble(1.2)
                .varBoolean(false)
                .varString("ahojky")
                .log();

        structLogger.info("test {} string literal {} for long {} and {}")
                .varDouble(1.2)
                .varBoolean(false)
                .varLong(1)
                .varString("tudu")
                .log();

        structLogger.info("testik {}")
                .varDouble(1.2)
                .log();

        structLogger.error("errorek {} {} {}")
                .varString("super error")
                .varLong(42)
                .varBoolean(true)
                .log();

        structLogger.warn("warning {} {} {}")
                .varBoolean(true)
                .varBoolean(false)
                .varInt(1)
                .log();

        structLogger.error("ulala")
                .log();
    }

    private void make8Slf4jLogCalls() {
        logger.info("test {} string literal {}", 1.2, false);

        logger.info("test {}", 1);

        logger.info("test {} string literal {} for {}", 1.2, false, "ahojky");

        logger.info("test {} string literal {} for long {} and {}", 1.2, false, 1, "tudu");

        logger.info("testik {}", 1.2);

        logger.error("errorek {} {} {}", "super error", 42, true);

        logger.warn("warning {} {} {}", true, false, 1);

        logger.error("ulala");
    }

    private void make8NgmonStructLogCalls() throws com.fasterxml.jackson.databind.JsonMappingException {
        StructLog<MyContext> LOGX = new StructLog<>(MyContext.class, new SimpleLogger());

        LOGX.info("test {} string literal {}")
                .varDouble(1.2)
                .varBoolean(false)
                .log();

        LOGX.info("test {}")
                .varInt(1)
                .log();

        LOGX.info("test {} string literal {} for {}")
                .varDouble(1.2)
                .varBoolean(false)
                .varString("ahojky")
                .log();

        LOGX.info("test {} string literal {} for long {} and {}")
                .varDouble(1.2)
                .varBoolean(false)
                .varLong(1)
                .varString("tudu")
                .log();

        LOGX.info("testik {}")
                .varDouble(1.2)
                .log();

        LOGX.error("errorek {} {} {}")
                .varString("super error")
                .varLong(42)
                .varBoolean(true)
                .log();

        LOGX.info("warning {} {} {}")
                .varBoolean(true)
                .varBoolean(false)
                .varInt(1)
                .log();

        LOGX.error("ulala")
                .log();
    }
}
