//package springboot.language;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/locale")
//public class languageController {
//	public String locale() {
//		return "locale";
//	}
//}
//	
//	
//	
//		
////		@Autowired
////		private MessageSource messageSource;
////		
////		 //取得當前語系			 
////	 	 //@param rq the rq
////		 //@param request the request
////		 //@return the string
////		  
////		@RequestMapping(value = { "/getCurrentLocale" }, method = { RequestMethod.GET }, consumes = {MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
////		@ResponseBody
////		public ResponseEntity<JSONObject> changeLocale(HttpServletRequest request, HttpServletResponse response) {
////			Locale locale = LocaleContextHolder.getLocale();
////			
////			JSONObject json = new JSONObject();
////			try {
////				json.put("locale","當前語系:" + messageSource.getMessage("current.locale", null, locale));
////			} catch (Exception e) {
////				e.printStackTrace();
////			}
////
////			return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
////		}
//	}
//	
//	
//	
//
