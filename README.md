# typeconverter-starter

## DefaultConversionService
> Spring Web 에서 RequestParam / PathVariable / RequestBody / ModelAttribute 를 받을 때 DefaultConversionService 를 통해서
> String -> 기재된 타입 으로 변환 한다.  
> DefaultConversionService 에는 기본적으로 대부분의 Primitive 타입들이 전부 정의되어 있으며 사용자 정의 class 혹은 
> value 를 가지는 enum 타입에 대한 convert 가 필요한 경우에 아래를 참조하여 컨버터를 추가 및 등록해준다.

## 사용자 정의 컨버터
### 컨버터 생성
> 사용자 정의 컨버터 생성시 `org.springframework.core.convert.converter.Converter` 인터페이스를 implements 하여
> `convert` 메서드를 Override 한다.

### 컨버터 등록
> WebConfig 에서 `addFormatters` 메서드를 Override 해서 registry 에 addConverter 메서드를 이용하여
> 위에서 생성한 컨버터 클래스를 추가해준다.
