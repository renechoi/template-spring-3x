package kr.rene.template.sampledomain1.api.domain.operators;

/**
 * @author : Rene Choi
 * @since : 2023/12/20
 */
public interface PkGenerator<T> {
	String generate(T data);
}
