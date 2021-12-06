# typeconverter-starter

## DefaultConversionService
> Spring Web 에서 RequestParam / PathVariable / RequestBody / ModelAttribute 를 받을 때 DefaultConversionService 를 통해서
> String -> 기재된 타입으로 자동 변환 한다.  
> DefaultConversionService 에는 기본적으로 대부분의 Primitive 타입들이 전부 정의되어 있으며 사용자 정의 class 혹은 
> value 를 가지는 enum 타입에 대한 convert 가 필요한 경우에 아래를 참조하여 컨버터를 추가 및 등록해준다.  
> 
> DefaultConversionService 직접 사용 예제를 보려면 ConversionServiceTest.java 참고    
> DefaultConversionService Spring Web 적용 예제를 보려면 ConverterApiController.java 참고

## 사용자 정의 Converter
### Converter 적용 대상
> @Controller 에 주로 사용  
> @RequestParam / @ModelAttribute 에 적용  
> 주의: Request Body 에는 적용 안됨.

### Converter 생성
> 사용자 정의 컨버터 생성시 `org.springframework.core.convert.converter.Converter` 인터페이스를 implements 하여
> `convert` 메서드를 Override 한다.  
> 
> converter 패키지 참고

### Converter 등록
> WebConfig 에서 `addFormatters` 메서드를 Override 해서 registry 에 addConverter 메서드를 이용하여
> 위에서 생성한 컨버터 클래스를 추가해준다.

## thymeleaf Converter 적용
### th:text
> 타임리프에서 변수 사용 시 ${변수명} 은 model 에 담긴 변수의 .toString() 을 적용하며,
> ${{변수명}} 은 model 에 담긴 변수에 변수 타입 -> String 컨버터를 적용한다.
> 
> ConverterController.java 의 GET localhost:8080/converter-view 실행 및 converter-view.html 참고

### th:field
> th:field 에 ${변수.필드명} 사용시 컨버터가 적용되며 th:value 사용시에는 .toString() 이 적용된다.
> 
> ConverterController.java 의 GET localhost:8080/converter/edit 실행 및 converter-form.html 참고

## Formatter
### Formatter 적용 대상
> @Controller 에 주로 사용  
> @RequestParam / @ModelAttribute 에 적용  
> 주의: Request Body 에는 적용 안됨.

### th:text
> 타임리프에서 변수 사용 시 ${{변수명}} 으로 사용하면 포맷터가 적용된다.

### Request Parameter
> `http://localhost:8080/hello-v2?data=10,000` 와 같이 RequestParam 으로 `10,000` 을 넘기면 포맷터에 의해 `10000` 로 변환된다. 

### Formatter vs Converter
> Converter 가 Formatter 보다 우선순위가 높다. 예를 들어 StringToIntegerConverter 와 StringToIntegerFormatter 가 있으면
> Converter 가 우선순위가 높음으로 Converter 만 적용된다.
