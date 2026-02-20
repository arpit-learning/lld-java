package dev.arpit.BookMyShow.mappers;

import dev.arpit.BookMyShow.dtos.CreateShowResponseDTO;
import dev.arpit.BookMyShow.models.Show;
import dev.arpit.BookMyShow.models.constants.Feature;

import java.util.ArrayList;
import java.util.List;

public class ShowDTOMapper {
    public static CreateShowResponseDTO getCreateShowResponseDTO(Show show) {
         CreateShowResponseDTO responseDTO = new CreateShowResponseDTO();
         responseDTO.setId(show.getId())
                 .setMovieId(show.getMovie().getId())
                 .setAuditoriumId(show.getAuditorium().getId())
                 .setShowStartTime(show.getShowStartTime().toString())
                 .setShowEndTime(show.getShowEndTime().toString());

         List<String> featuresStr = new ArrayList<>();
         for(Feature feature: show.getFeatures()) {
             featuresStr.add(feature.toString());
         }
         responseDTO.setFeatures(featuresStr);

         return responseDTO;
    }
}
