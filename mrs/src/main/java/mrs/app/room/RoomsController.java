package mrs.app.room;

import mrs.domain.model.ReservableRoom;
import mrs.domain.service.room.RoomService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("rooms")
public class RoomsController {
    @Autowired
    RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    String listRooms(Model model) {
        LocalDate today = LocalDate.now();
        List<ReservableRoom> rooms = roomService.findReserableRooms(today);
        model.addAttribute("date", today);
        model.addAttribute("rooms", rooms);
        return "room/listRooms";
    }

    @RequestMapping(path = "{date}", method = RequestMethod.GET)
    String listRooms(
            @DateTimeFormatter(iso = DateTimeFormat.ISO.DATE) @PathVariable("date") LocalDate date, Model model) {
        List<ReservableRoom> rooms = roomService.findReserableRooms(date);
        model.addAttribute("rooms", rooms);
        return "room/listRooms";
    }
}
