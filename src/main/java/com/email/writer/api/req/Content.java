package com.email.writer.api.req;

import java.util.List;

import lombok.Data;

@Data
public class Content {
	private List<Part> parts;
}
