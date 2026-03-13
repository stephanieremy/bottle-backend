package com.bottle.app;

import com.bottle.app.application.BottleService;
import com.bottle.app.domain.BottleNotFoundException;
import com.bottle.app.domain.BottleRepository;
import com.bottle.app.domain.bottle.Bottle;
import com.bottle.app.domain.bottle.WineType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BottleServiceTest {

    @Mock
    private BottleRepository bottleRepository;

    private BottleService bottleService;

    @BeforeEach
    void setUp() {
        bottleService = new BottleService(bottleRepository);
    }

    @Test
    void findById_shouldReturnBottle_whenBottleExists() {
        UUID id = UUID.randomUUID();
        Bottle bottle = new Bottle();
        bottle.setId(id);
        when(bottleRepository.findById(id)).thenReturn(Optional.of(bottle));

        Bottle result = bottleService.findById(id);

        assertThat(result.getId()).isEqualTo(id);
    }

    @Test
    void findById_shouldThrowException_whenBottleNotFound() {
        UUID id = UUID.randomUUID();
        when(bottleRepository.findById(id)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> bottleService.findById(id))
                .isInstanceOf(BottleNotFoundException.class)
                .hasMessage("Bottle not found.");
    }

    @Test
    void createBottle_shouldReturnSavedBottle() {
        Bottle bottle = new Bottle();
        bottle.setName("Château Margaux");
        when(bottleRepository.save(bottle)).thenReturn(bottle);

        Bottle result = bottleService.createBottle(bottle);

        assertThat(result.getName()).isEqualTo("Château Margaux");
    }

    @Test
    void findAllBottles_shouldReturnAllBottles_whenNoTypeFilter() {
        List<Bottle> bottles = List.of(
                new Bottle(),
                new Bottle()
        );
        when(bottleRepository.findAll(null)).thenReturn(bottles);

        List<Bottle> result = bottleService.findAllBottles(null);

        assertThat(result).hasSize(2);
    }

    @Test
    void findAllBottles_shouldReturnFilteredBottles_whenTypeProvided() {
        Bottle bottle = new Bottle();
        bottle.setType(WineType.RED);
        when(bottleRepository.findAll(WineType.RED)).thenReturn(List.of(bottle));

        List<Bottle> result = bottleService.findAllBottles(WineType.RED);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getType()).isEqualTo(WineType.RED);
    }
}