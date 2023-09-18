package com.example.interfaces;

import java.util.List;
import java.util.Set;

public interface FilterContent {
	void setFilterContent(List<String> list , String filterType) throws Exception;
	Set<String> getAbusiveFilterContent();
	Set<String> getPersonalFilterContent();
	Set<String> getDuplicativeFilterContent();
}
