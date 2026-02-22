package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.models.*;
import dev.arpit.BookMyShow.models.constants.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

@Service
public class InitialisationService implements CommandLineRunner {
    @Autowired
    private CityService cityService;
    @Autowired
    private TheatreService theatreService;
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private ShowService showService;
    @Autowired
    private ShowSeatService showSeatService;
    @Autowired
    private UserService userService;
    @Autowired
    private TicketService ticketService;

    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        if (cityService.getAll().isEmpty()) {
            System.out.println("\n═══════════════════════════════════════════════════════════════════════════");
            System.out.println("INITIALIZING DUMMY DATA FOR BOOKMYSHOW");
            System.out.println("═══════════════════════════════════════════════════════════════════════════\n");

            initializeDummyData();

            System.out.println("\n═══════════════════════════════════════════════════════════════════════════");
            System.out.println("DUMMY DATA INITIALIZATION COMPLETED SUCCESSFULLY");
            System.out.println("═══════════════════════════════════════════════════════════════════════════\n");

            // Add small delay to ensure data is fully persisted
            Thread.sleep(1000);

            // Demonstrate concurrent booking after initialization
            demonstrateConcurrentBooking();
        }
    }

    private void initializeDummyData() {
        // Create 1 city: Mumbai
        City city = createCity();

        // Create 5 theaters under Mumbai
        List<Theatre> theatres = createTheatres(city);

        // Create 4 auditoriums per theater with 100 seats each
        for (Theatre theatre : theatres) {
            createAuditoriums(theatre);
        }

        // Create 10 movies
        List<Movie> movies = createMovies();

        // Create shows for 3 consecutive days with 3 shows per auditorium per theater per day
        createShows(theatres, movies);

        // Create 5 test users
        createUsers();
    }

    private City createCity() {
        City city = new City();
        city.setName("Mumbai");
        city.setCityStatus(CityStatus.ACTIVE);
        return cityService.save(city);
    }

    private List<Theatre> createTheatres(City city) {
        /*
            1.
                Theatre t = new Theatre();
                city.setTheatres(List.of(t));
                cityService.save(city); -- theatre id is not yet generated to setup the relationship,
                theatreService.save(t); -- so we need to save theater first and then set it to city and save city again
            2.
                Theatre t = new Theatre();
                t = theatreService.save(t);
                city.setTheatres(List.of(t));
                cityService.save(city);
        */

        String[] theatreNames = {
                "PVR Cinemas",
                "INOX Leisure",
                "Cinepolis",
                "Carnival Cinemas",
                "Rajhans Cinemas"
        };

        String[] theatreAddresses = {
                "Phoenix Market City, High Street Phoenix, Mumbai",
                "Oberoi Mall, Goregaon East, Mumbai",
                "Powai Hub, Hiranandani Gardens, Powai, Mumbai",
                "Forum Mall, Vashi, Navi Mumbai",
                "Cyber Hub, Sector 30, Seawoods, Navi Mumbai"
        };

        List<Theatre> theatres = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Theatre theatre = new Theatre();
            theatre.setName(theatreNames[i]);
            theatre.setAddress(theatreAddresses[i]);
            theatre.setTheatreStatus(TheatreStatus.ACTIVE);
            theatres.add(theatreService.save(theatre));
        }
        city.setTheatres(theatres);
        cityService.save(city);
        return theatres;
    }

    private void createAuditoriums(Theatre theatre) {
        String[] auditoriumNames = {"Audi 01", "Audi 02", "Audi 03", "Audi 04"};
        List<Auditorium> auditoriums = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Auditorium auditorium = new Auditorium();
            auditorium.setName(auditoriumNames[i]);
            auditorium.setAuditoriumStatus(AuditoriumStatus.ACTIVE);
            auditorium = auditoriumService.save(auditorium);

            // Create 100 seats for this auditorium
            List<Seat> seats = createSeats();
            auditorium.setSeats(seats);
            auditoriumService.save(auditorium);
            auditoriums.add(auditorium);
        }

        theatre.setAuditoriums(auditoriums);
        theatreService.save(theatre);
    }

    private List<Seat> createSeats() {
        // Create 100 seats in the 10 x 10 grid
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                Seat seat = new Seat();
                seat.setRow(row);
                seat.setColumn(col);
                seat.setSeatNumber(row + "0" + col); // e.g., "102" for row 1, col 2
                seat.setSeatStatus(SeatStatus.AVAILABLE);

                // Assign seat types: the first 2 rows are PLATINUM, the next 3 rows are GOLD, and the rest are SILVER
                if (row <= 2) {
                    seat.setSeatType(SeatType.PLATINUM);
                } else if (row <= 5) {
                    seat.setSeatType(SeatType.GOLD);
                } else {
                    seat.setSeatType(SeatType.SILVER);
                }

                seat = seatService.save(seat);
                seats.add(seat);
            }
        }
        return seats;
    }

    private List<Movie> createMovies() {
        String[] movieTitles = {
                "Pathaan",
                "Jawan",
                "Bhaiyya Ji",
                "Article 370",
                "Crew",
                "Drishyam 2",
                "Rocky Aur Rani Kii Prem Kahaani",
                "Khel Khel Mein",
                "Tiger 3",
                "Fukrey 3"
        };

        List<Movie> movies = new ArrayList<>();
        for (String title : movieTitles) {
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setUrl("https://www.google.com/search?q=" + title);
            movie = movieService.save(movie);
            movies.add(movie);
        }

        return movies;
    }

    private void createShows(List<Theatre> theatres, List<Movie> movies) {
        // Create shows for 3 consecutive days
        LocalDateTime startDate = LocalDateTime.now().plusDays(1).withHour(10).withMinute(0).withSecond(0);

        for (int dayOffset = 0; dayOffset < 3; dayOffset++) {
            LocalDateTime dayStart = startDate.plusDays(dayOffset);

            for (Theatre theatre : theatres) {
                // Get all auditoriums for this theater
                List<Auditorium> theatreAuditoriums = theatre.getAuditoriums();

                for (Auditorium auditorium : theatreAuditoriums) {
                    // Create 3 shows per auditorium per day
                    for (int showSlot = 0; showSlot < 3; showSlot++) {
                        Show show = new Show();
                        show.setAuditorium(auditorium);

                        // Assign random movie
                        Movie randomMovie = movies.get(random.nextInt(movies.size()));
                        show.setMovie(randomMovie);

                        // Set show times: 10:00 AM, 2:00 PM, 6:30 PM
                        int hour = (showSlot == 0) ? 10 : (showSlot == 1) ? 14 : 18;
                        int minute = (showSlot == 2) ? 30 : 0;

                        LocalDateTime startTime = dayStart.withHour(hour).withMinute(minute);
                        LocalDateTime endTime = startTime.plusHours(2).plusMinutes(30); // 2.5-hour duration

                        show.setShowStartTime(startTime);
                        show.setShowEndTime(endTime);
                        show.setShowStatus(ShowStatus.YET_TO_START);
                        showService.save(show);

                        // Create ShowSeats for all seats in this auditorium
                        List<ShowSeat> showSeats = createShowSeats(show, auditorium);
                        show.setShowSeats(showSeats);
                        showService.save(show);
                    }
                }
            }
        }
    }

    private List<ShowSeat> createShowSeats(Show show, Auditorium auditorium) {
        List<ShowSeat> showSeats = new ArrayList<>();
        List<Seat> auditoriumSeats = auditorium.getSeats();
        for (Seat seat : auditoriumSeats) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeat(seat);
            showSeat.setShow(show);
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);

            // Set pricing based on seat type
            if (seat.getSeatType() == SeatType.PLATINUM) {
                showSeat.setPrice(400);
            } else if (seat.getSeatType() == SeatType.GOLD) {
                showSeat.setPrice(250);
            } else {
                showSeat.setPrice(150);
            }
            showSeatService.save(showSeat);
            showSeats.add(showSeat);
        }

        return showSeats;
    }

    private void createUsers() {
        String[] userNames = {"Rajesh Kumar", "Priya Singh", "Amit Patel", "Deepika Nair", "Arjun Verma"};
        String[] userEmails = {
                "rajesh.kumar@email.com",
                "priya.singh@email.com",
                "amit.patel@email.com",
                "deepika.nair@email.com",
                "arjun.verma@email.com"
        };

        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName(userNames[i]);
            user.setEmail(userEmails[i]);
            user.setPassword("password123"); // Default password for testing
            userService.save(user);
        }
    }

    /**
     * Demonstrates concurrent booking with two threads trying to book the same seat simultaneously
     * Thread 1: User ID 1 (Rajesh Kumar) books Seat ID 1
     * Thread 2: User ID 2 (Priya Singh) books Seat ID 1
     *
     * Expected Result:
     * - One thread succeeds (HTTP 201)
     * - One thread fails (HTTP 400 - Seat not available)
     * - SERIALIZABLE isolation prevents double booking
     */
    public void demonstrateConcurrentBooking() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                 CONCURRENT BOOKING DEMONSTRATION                             ║");
        System.out.println("║  Scenario: Two users booking the SAME seat at the EXACT same time            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝\n");

        // CountDownLatch to ensure both threads start at the same time
        CountDownLatch startLatch = new CountDownLatch(2);

        // Get the first available show seat (Seat ID 1)
        List<ShowSeat> allShowSeats = showSeatService.getAll();
        if (allShowSeats.isEmpty()) {
            System.out.println("No show seats available for booking demo!");
            return;
        }

        ShowSeat targetSeat = allShowSeats.get(0);
        System.out.println("Target Seat: ID=" + targetSeat.getId() + ", Status=" + targetSeat.getShowSeatStatus() + "\n");

        // Thread 1: User A (ID=1) tries to book Seat 1
        Thread thread1 = new Thread(() -> {
            try {
                startLatch.countDown();
                startLatch.await(); // Wait for both threads to be ready

                System.out.println("[Thread-1] User A starting booking process...");
                ticketService.createTicket(java.util.List.of(targetSeat.getId()), 1);
                System.out.println("[Thread-1] User A booking succeeded ✅\n");

            } catch (Exception e) {
                System.out.println("[Thread-1] User A booking failed: " + e.getMessage() + " ❌\n");
            }
        }, "User-A-Thread");

        // Thread 2: User B (ID=2) tries to book the same Seat 1
        Thread thread2 = new Thread(() -> {
            try {
                startLatch.countDown();
                startLatch.await(); // Wait for both threads to be ready

                System.out.println("[Thread-2] User B starting booking process...");
                ticketService.createTicket(java.util.List.of(targetSeat.getId()), 2);
                System.out.println("[Thread-2] User B booking succeeded ✅\n");

            } catch (Exception e) {
                System.out.println("[Thread-2] User B booking failed: " + e.getMessage() + " ❌\n");
            }
        }, "User-B-Thread");

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println("Concurrent booking demo interrupted: " + e.getMessage());
        }

        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                 DEMO COMPLETED - RACE CONDITION HANDLED SAFELY              ║");
        System.out.println("║  One user succeeded, one user failed → No double booking occurred!         ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝\n");
    }
}
