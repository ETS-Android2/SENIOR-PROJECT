package com.tolgacobanoglu.expertcentralcarpolicy.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tolgacobanoglu.expertcentralcarpolicy.Utils;
import com.tolgacobanoglu.expertcentralcarpolicy.database.Update;
import com.tolgacobanoglu.expertcentralcarpolicy.databinding.ActivityChipBinding;
import com.tolgacobanoglu.expertcentralcarpolicy.regex.LicensePlateValidator;

import java.util.HashMap;
import java.util.Map;

public class ChipActivity extends AppCompatActivity {

    private ActivityChipBinding binding;
    Map<String, String> map;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityChipBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        map = new HashMap<>();
        map.put("bonnet","UNEXAMINED");
        map.put("frontBumper","UNEXAMINED");
        map.put("rearBumper","UNEXAMINED");
        map.put("leftFrontDoor","UNEXAMINED");
        map.put("rightFrontDoor","UNEXAMINED");
        map.put("rightBackDoor","UNEXAMINED");
        map.put("leftBackDoor","UNEXAMINED");
        map.put("baggage","UNEXAMINED");
        map.put("roof","UNEXAMINED");
        map.put("leftMirror","UNEXAMINED");
        map.put("rightMirror","UNEXAMINED");
        map.put("steeringWheel","UNEXAMINED");
        map.put("airConditions","UNEXAMINED");
        map.put("carUpholstery","UNEXAMINED");
        map.put("headliner","UNEXAMINED");
        map.put("airbag","UNEXAMINED");

        binding.bonnetTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO TEKRAR AÇILMA KOY
                if (binding.bonnetChips.getVisibility() == View.INVISIBLE )
                {
                    binding.bonnetChips.setVisibility(View.VISIBLE);
                }
                else
                {
                    binding.bonnetChips.setVisibility(View.INVISIBLE);
                }

            }
        });


        binding.bonnetFactoryNewChip.setOnClickListener(v -> {
            map.put("bonnet","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.bonnetPaintedChip.setOnClickListener(v -> {
            map.put("bonnet","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.bonnetDamagedChip.setOnClickListener(v -> {
            map.put("bonnet","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.bonnetModifiedChip.setOnClickListener(v -> {
            map.put("bonnet","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.bonnetScratchChip.setOnClickListener(v -> {
            map.put("bonnet","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.bonnetSpottingInChip.setOnClickListener(v -> {
            map.put("bonnet","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.frontBumperFactoryNewChip.setOnClickListener(v -> {
            map.put("frontBumper","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.frontBumperPaintedChip.setOnClickListener(v -> {
            map.put("frontBumper","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.frontBumperDamagedChip.setOnClickListener(v -> {
            map.put("frontBumper","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.frontBumperModifiedChip.setOnClickListener(v -> {
            map.put("frontBumper","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.frontBumperScratchChip.setOnClickListener(v -> {
            map.put("frontBumper","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.frontBumperSpottingInChip.setOnClickListener(v -> {
            map.put("frontBumper","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.rearBumperFactoryNewChip.setOnClickListener(v -> {
            map.put("rearBumper","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.rearBumperPaintedChip.setOnClickListener(v -> {
            map.put("rearBumper","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.rearBumperDamagedChip.setOnClickListener(v -> {
            map.put("rearBumper","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.rearBumperModifiedChip.setOnClickListener(v -> {
            map.put("rearBumper","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.rearBumperScratchChip.setOnClickListener(v -> {
            map.put("rearBumper","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.rearBumperSpottingInChip.setOnClickListener(v -> {
            map.put("rearBumper","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.leftFrontDoorFactoryNewChip.setOnClickListener(v -> {
            map.put("leftFrontDoor","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.leftFrontDoorPaintedChip.setOnClickListener(v -> {
            map.put("leftFrontDoor","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.leftFrontDoorDamagedChip.setOnClickListener(v -> {
            map.put("leftFrontDoor","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.leftFrontDoorModifiedChip.setOnClickListener(v -> {
            map.put("leftFrontDoor","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.leftFrontDoorScratchChip.setOnClickListener(v -> {
            map.put("leftFrontDoor","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.leftFrontDoorSpottingInChip.setOnClickListener(v -> {
            map.put("leftFrontDoor","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.rightFrontDoorFactoryNewChip.setOnClickListener(v -> {
            map.put("rightFrontDoor","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.rightFrontDoorPaintedChip.setOnClickListener(v -> {
            map.put("rightFrontDoor","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.rightFrontDoorDamagedChip.setOnClickListener(v -> {
            map.put("rightFrontDoor","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.rightFrontDoorModifiedChip.setOnClickListener(v -> {
            map.put("rightFrontDoor","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.rightFrontDoorScratchChip.setOnClickListener(v -> {
            map.put("rightFrontDoor","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.rightFrontDoorSpottingInChip.setOnClickListener(v -> {
            map.put("rightFrontDoor","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.rightBackDoorFactoryNewChip.setOnClickListener(v -> {
            map.put("rightBackDoor","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.rightBackDoorPaintedChip.setOnClickListener(v -> {
            map.put("rightBackDoor","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.rightBackDoorDamagedChip.setOnClickListener(v -> {
            map.put("rightBackDoor","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.rightBackDoorModifiedChip.setOnClickListener(v -> {
            map.put("rightBackDoor","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.rightBackDoorScratchChip.setOnClickListener(v -> {
            map.put("rightBackDoor","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.rightBackDoorSpottingInChip.setOnClickListener(v -> {
            map.put("rightBackDoor","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.leftBackDoorFactoryNewChip.setOnClickListener(v -> {
            map.put("leftBackDoor","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.leftBackDoorPaintedChip.setOnClickListener(v -> {
            map.put("leftBackDoor","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.leftBackDoorDamagedChip.setOnClickListener(v -> {
            map.put("leftBackDoor","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.leftBackDoorModifiedChip.setOnClickListener(v -> {
            map.put("leftBackDoor","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.leftBackDoorScratchChip.setOnClickListener(v -> {
            map.put("leftBackDoor","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.leftBackDoorSpottingInChip.setOnClickListener(v -> {
            map.put("leftBackDoor","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.baggageFactoryNewChip.setOnClickListener(v -> {
            map.put("baggage","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.baggagePaintedChip.setOnClickListener(v -> {
            map.put("baggage","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.baggageDamagedChip.setOnClickListener(v -> {
            map.put("baggage","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.baggageModifiedChip.setOnClickListener(v -> {
            map.put("baggage","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.baggageScratchChip.setOnClickListener(v -> {
            map.put("baggage","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.baggageSpottingInChip.setOnClickListener(v -> {
            map.put("baggage","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.roofFactoryNewChip.setOnClickListener(v -> {
            map.put("roof","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.roofPaintedChip.setOnClickListener(v -> {
            map.put("roof","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.roofDamagedChip.setOnClickListener(v -> {
            map.put("roof","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.roofModifiedChip.setOnClickListener(v -> {
            map.put("roof","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.roofScratchChip.setOnClickListener(v -> {
            map.put("roof","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.roofSpottingInChip.setOnClickListener(v -> {
            map.put("roof","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.leftMirrorFactoryNewChip.setOnClickListener(v -> {
            map.put("leftMirror","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.leftMirrorPaintedChip.setOnClickListener(v -> {
            map.put("leftMirror","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.leftMirrorDamagedChip.setOnClickListener(v -> {
            map.put("leftMirror","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.leftMirrorModifiedChip.setOnClickListener(v -> {
            map.put("leftMirror","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.leftMirrorScratchChip.setOnClickListener(v -> {
            map.put("leftMirror","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.leftMirrorSpottingInChip.setOnClickListener(v -> {
            map.put("leftMirror","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.rightMirrorFactoryNewChip.setOnClickListener(v -> {
            map.put("rightMirror","FACTORY NEW");
            Toast.makeText(ChipActivity.this, "FACTORY NEW", Toast.LENGTH_SHORT).show();
        });

        binding.rightMirrorPaintedChip.setOnClickListener(v -> {
            map.put("rightMirror","PAINTED");
            Toast.makeText(ChipActivity.this,"PAINTED", Toast.LENGTH_SHORT).show();
        });

        binding.rightMirrorDamagedChip.setOnClickListener(v -> {
            map.put("rightMirror","DAMAGED");
            Toast.makeText(ChipActivity.this,"DAMAGED", Toast.LENGTH_SHORT).show();
        });

        binding.rightMirrorModifiedChip.setOnClickListener(v -> {
            map.put("rightMirror","MODIFIED");
            Toast.makeText(ChipActivity.this,"MODIFIED", Toast.LENGTH_SHORT).show();
        });

        binding.rightMirrorScratchChip.setOnClickListener(v -> {
            map.put("rightMirror","SCRATCH");
            Toast.makeText(ChipActivity.this,"SCRATCH", Toast.LENGTH_SHORT).show();
        });

        binding.rightMirrorSpottingInChip.setOnClickListener(v -> {
            map.put("rightMirror","SPOTTING IN");
            Toast.makeText(ChipActivity.this,"SPOTTING IN", Toast.LENGTH_SHORT).show();
        });

        binding.steeringWheelGoodChip.setOnClickListener(v -> {
            map.put("steeringWheel","GOOD");
            Toast.makeText(ChipActivity.this,"GOOD", Toast.LENGTH_SHORT).show();
        });

        binding.steeringWheelMediumChip.setOnClickListener(v -> {
            map.put("steeringWheel","MEDIUM");
            Toast.makeText(ChipActivity.this,"MEDIUM", Toast.LENGTH_SHORT).show();
        });

        binding.steeringWheelWornChip.setOnClickListener(v -> {
            map.put("steeringWheel","WORN");
            Toast.makeText(ChipActivity.this,"WORN", Toast.LENGTH_SHORT).show();
        });

        binding.airConditionsGoodChip.setOnClickListener(v -> {
            map.put("airConditions","GOOD");
            Toast.makeText(ChipActivity.this,"GOOD", Toast.LENGTH_SHORT).show();
        });

        binding.airConditionsMediumChip.setOnClickListener(v -> {
            map.put("airConditions","MEDIUM");
            Toast.makeText(ChipActivity.this,"MEDIUM", Toast.LENGTH_SHORT).show();
        });

        binding.airConditionsWornChip.setOnClickListener(v -> {
            map.put("airConditions","WORN");
            Toast.makeText(ChipActivity.this,"WORN", Toast.LENGTH_SHORT).show();
        });

        binding.carUpholsteryGoodChip.setOnClickListener(v -> {
            map.put("carUpholstery","GOOD");
            Toast.makeText(ChipActivity.this,"GOOD", Toast.LENGTH_SHORT).show();
        });

        binding.carUpholsteryMediumChip.setOnClickListener(v -> {
            map.put("carUpholstery","MEDIUM");
            Toast.makeText(ChipActivity.this,"MEDIUM", Toast.LENGTH_SHORT).show();
        });

        binding.carUpholsteryWornChip.setOnClickListener(v -> {
            map.put("carUpholstery","WORN");
            Toast.makeText(ChipActivity.this,"WORN", Toast.LENGTH_SHORT).show();
        });

        binding.headlinerGoodChip.setOnClickListener(v -> {
            map.put("headliner","GOOD");
            Toast.makeText(ChipActivity.this,"GOOD", Toast.LENGTH_SHORT).show();
        });

        binding.headlinerMediumChip.setOnClickListener(v -> {
            map.put("headliner","MEDIUM");
            Toast.makeText(ChipActivity.this,"MEDIUM", Toast.LENGTH_SHORT).show();
        });

        binding.headlinerWornChip.setOnClickListener(v -> {
            map.put("headliner","WORN");
            Toast.makeText(ChipActivity.this,"WORN", Toast.LENGTH_SHORT).show();
        });

        binding.airbagNormalChip.setOnClickListener(v ->
        {
            map.put("airbag","NORMAL");
            Toast.makeText(ChipActivity.this,"WORN", Toast.LENGTH_SHORT).show();
        });

        binding.airbagRepairedChip.setOnClickListener(v ->
        {
            map.put("airbag","REPAIRED");
            Toast.makeText(ChipActivity.this,"REPAIRED", Toast.LENGTH_SHORT).show();
        });

        binding.airbagBreakOutChip.setOnClickListener(v ->
        {
            map.put("airbag","BREAK OUT");
            Toast.makeText(ChipActivity.this,"BREAK OUT", Toast.LENGTH_SHORT).show();
        });

        binding.saveButton.setOnClickListener(v -> {
            String report = Utils.mapToString(map);
            Update update = new Update();
            LicensePlateValidator validator = new LicensePlateValidator();
            String cityCode = binding.cityCodeInput.getText().toString();
            String digitGroup = binding.digitGroupInput.getText().toString();
            String letterGroup = binding.letterGroupInput.getText().toString();


            if (validator.checkCityCodeWithoutLicensePlate(cityCode))
            {
                if (validator.checkDigitGroupWithoutLicensePlate(digitGroup))
                {
                    if (validator.checkLetterGroupWithoutLicensePlate(letterGroup))
                    {
                        update.updateCarAfterExpert(ChipActivity.this,cityCode,letterGroup,digitGroup,report);
                        Intent intent = new Intent(ChipActivity.this,HomePageActivity.class);
                        finish();
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(ChipActivity.this, "Invalid letter group!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(ChipActivity.this, "Invalid digit group!!", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(ChipActivity.this, "Invalid city code!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}