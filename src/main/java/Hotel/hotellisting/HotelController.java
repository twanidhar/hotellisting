package Hotel.hotellisting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class HotelController {
	
	@Autowired 
	private HotelDao hotelDao;
	
	@RequestMapping("/")
	public ModelAndView home() {
//		ModelAndView mav = new ModelAndView("home");
//		mav.addObject("city", hotelDao.findCityList());
		return new ModelAndView("home");

}
	@RequestMapping("/Hotels") 
	public ModelAndView listHotel(@RequestParam(name="city", required=false) String city,
			@RequestParam(name="price_per_night") Integer pricePerNight) {
			ModelAndView mav1 = new ModelAndView("hotels");
			mav1.addObject("city", city);
			if (pricePerNight != null) {
				mav1.addObject("hotelList", hotelDao.findAll(city, pricePerNight));
			} else {
				mav1.addObject("hotelList", hotelDao.findByCity(city));
			}
			return mav1;
		
		}
	}
