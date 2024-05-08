package com.example.demo.flowable; /**
 * This content is released under the MIT License (MIT)
 * <p>
 * Copyright (c) 2020, canchito-dev
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author José Carlos Mendoza Prego
 * @copyright Copyright (c) 2020, canchito-dev (http://www.canchito-dev.com)
 * @license http://opensource.org/licenses/MIT	MIT License
 * @link http://www.canchito-dev.com/public/blog/2020/05/14/flowable-custom-engine-configuration/
 * @link https://github.com/canchito-dev/flowable-custom-engine-configuration/
 **/


import com.zaxxer.hikari.HikariDataSource;
import org.flowable.common.engine.impl.persistence.StrongUuidGenerator;
import org.flowable.content.api.ContentService;
import org.flowable.content.engine.ContentEngine;
import org.flowable.content.engine.impl.cfg.StandaloneContentEngineConfiguration;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CustomEngineConfiguration {

    @Bean
    @ConfigurationProperties("flowable.datasource")
    public DataSourceProperties flowableDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public HikariDataSource flowableDataSource(
            @Qualifier("flowableDataSourceProperties") DataSourceProperties flowableDataSourceProperties
    ) {
        return flowableDataSourceProperties
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    EngineConfigurationConfigurer<SpringProcessEngineConfiguration> engineConfigurationConfigurer(
            @Qualifier("flowableDataSource") DataSource dataSource
    ) {
        return engineConfiguration -> {
            /**
             * Flowable DOCS (v6.5.0)'s user guide - UUID ID generator for high concurrency
             * https://flowable.com/open-source/docs/bpmn/ch18-Advanced/#uuid-id-generator-for-high-concurrency
             **/
            engineConfiguration.setIdGenerator(new StrongUuidGenerator());
            engineConfiguration.setDataSource(dataSource);
            /**
             * Flowable DOCS (v6.5.0)'s user guide - Database configuration
             * https://flowable.com/open-source/docs/bpmn/ch03-Configuration/#database-configuration
             *
             * The data source that is constructed based on the provided JDBC properties will have the default MyBatis connection pool settings. The following attributes can
             * optionally be set to tweak that connection pool (taken from the MyBatis documentation):
             * - jdbcMaxActiveConnections: The number of active connections that the connection pool at maximum at any time can contain. Default is 10.
             * - jdbcMaxIdleConnections: The number of idle connections that the connection pool at maximum at any time can contain.
             * - jdbcMaxCheckoutTime: The amount of time in milliseconds a connection can be checked out from the connection pool before it is forcefully returned. Default is 20000 (20 seconds).
             * - jdbcMaxWaitTime: This is a low level setting that gives the pool a chance to print a log status and re-attempt the acquisition of a connection in the case that it is taking unusually
             * 					  long (to avoid failing silently forever if the pool is misconfigured) Default is 20000 (20 seconds).
             **/
            //  engineConfiguration.addConfigurator(new FormIOEngineConfigurer());

            /**
             * Flowable DOCS (v6.5.0)'s user guide - Event handlers
             * https://flowable.com/open-source/docs/bpmn/ch03-Configuration/#event-handlers
             **/
        };
    }

    @Bean
    public ContentEngine contentEngine(
            @Qualifier("flowableDataSource") DataSource dataSource
    ) {
        StandaloneContentEngineConfiguration configuration = new StandaloneContentEngineConfiguration();

        configuration.setDataSource(dataSource);
        configuration.setIdGenerator(new StrongUuidGenerator());

        return configuration.buildContentEngine();
    }

    @Bean
    public ContentService contentService(ContentEngine contentEngine){
        return contentEngine.getContentService();
    }


}