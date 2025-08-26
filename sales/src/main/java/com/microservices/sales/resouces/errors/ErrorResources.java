package com.microservices.sales.resouces.errors;

import lombok.Getter;


public record ErrorResources (
long timestamp,
String message

){
}
