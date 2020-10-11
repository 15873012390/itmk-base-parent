package com.itmk.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(JSONArray.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class JsonTypeHandler extends BaseTypeHandler<JSONArray> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, JSONArray objects, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,String.valueOf(objects.toJSONString()));
    }

    @Override
    public JSONArray getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String sqlJson=resultSet.getString(s);
        if (null!=sqlJson){
            return JSONObject.parseArray(sqlJson);
        }
        return null;
    }

    @Override
    public JSONArray getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String sqlJson=resultSet.getString(i);
        if (null!=sqlJson){
            return JSONObject.parseArray(sqlJson);
        }
        return null;
    }

    @Override
    public JSONArray getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String sqlJson=callableStatement.getNString(i);
        if (null!=sqlJson){
            return JSONObject.parseArray(sqlJson);
        }
        return null;
    }
}
