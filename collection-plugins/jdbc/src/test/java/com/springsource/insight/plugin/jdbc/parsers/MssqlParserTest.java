/**
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.springsource.insight.plugin.jdbc.parsers;

import org.junit.Before;

import com.springsource.insight.plugin.jdbc.parser.DatabaseType;
import com.springsource.insight.plugin.jdbc.parser.parsers.MssqlParser;


public class MssqlParserTest extends SqlParserTestImpl implements SqlParsetTest {

	@Before
	public void setup() {

		parser = new MssqlParser();

		testCases.add(new SqlTestEntry("jdbc:microsoft:sqlserver://host:1434;DatabaseName=dbname",
								"host",
								1434,
								"dbname"));
		testCases.add(new SqlTestEntry("jdbc:microsoft:sqlserver://host:1434;DatabaseName=",
								"host",
								1434,
								""));
		//should it be without the colon? (i.e - jdbc:microsoft:sqlserver://host;DatabaseName=dbname)
		testCases.add(new SqlTestEntry("jdbc:microsoft:sqlserver://host:;DatabaseName=dbname",
								"host",
								1433,
								"dbname"));

		testCases.add(new SqlTestEntry("jdbc:microsoft:sqlserver://:1434;DatabaseName=dbname",
								"localhost",
								1434,
								"dbname"));
	}

	@Override
	public DatabaseType getType() {
		return DatabaseType.MSSQL;
	}

}
