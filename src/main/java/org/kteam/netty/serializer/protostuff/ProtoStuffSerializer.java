package org.kteam.netty.serializer.protostuff;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.kteam.netty.serializer.Serializer;


/**
 * 具体实现
 * @author BazingaLyn
 * @description
 * @time 2016年7月26日18:55:54
 * @modifytime
 */
public class ProtoStuffSerializer implements Serializer {

	@SuppressWarnings("unchecked")
	public <T> byte[] writeObject(T obj) {

		Class<T> cls = (Class<T>) obj.getClass();
		LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
		try {
			Schema<T> schema = RuntimeSchema.getSchema(cls);
			return ProtobufIOUtil.toByteArray(obj, schema, buffer);
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		} finally {
			buffer.clear();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T readObject(byte[] bytes, Class<T> clazz) {
		try {
			T message = clazz.newInstance();
			Schema schema = RuntimeSchema.getSchema(clazz);
			ProtobufIOUtil.mergeFrom(bytes, message, schema);
			return message;
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}}
