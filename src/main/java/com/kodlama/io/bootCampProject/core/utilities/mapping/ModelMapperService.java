package com.kodlama.io.bootCampProject.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
 public	ModelMapper forResponse();
 public	ModelMapper forRequest();
}
