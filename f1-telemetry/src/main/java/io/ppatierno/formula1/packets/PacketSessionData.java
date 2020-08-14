/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.enums.Formula;
import io.ppatierno.formula1.enums.SafetyCarStatus;
import io.ppatierno.formula1.enums.SessionType;
import io.ppatierno.formula1.enums.Track;
import io.ppatierno.formula1.enums.Weather;
import io.ppatierno.formula1.enums.ZoneFlag;
import io.ppatierno.formula1.packets.Packet;

/**
 * Session Packet
 * 
 * The session packet includes details about the current session in progress.
 */
public class PacketSessionData extends Packet {

    private Weather weather;
    private short trackTemperature;
    private short airTemperature;
    private short totalLaps;
    private int trackLength;
    private SessionType sessionType;
    private Track trackId;
    private Formula formula;
    private int sessionTimeLeft;
    private int sessionDuration;
    private short pitSpeedLimit;
    private short gamePaused;
    private short isSpectating;
    private short spectatorCarIndex;
    private short sliProNativeSupport;
    private short numMarshalZones;
    private List<MarshalZone> marshalZones = new ArrayList<>(PacketConstants.MARSHAL_ZONES);
    private SafetyCarStatus safetyCarStatus;
    private short networkGame;
    private short numWeatherForecastSamples;
    private List<WeatherForecastSample> weatherForecastSamples = new ArrayList<>(PacketConstants.WEATHER_FORECAST_SAMPLES);

    /**
     * @return Weather
     * Weather - 0 = clear, 1 = light cloud, 2 = overcast
     * 3 = light rain, 4 = heavy rain, 5 = storm
     */
    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    /**
     * @return Track temp. in degrees celsius
     */
    public short getTrackTemperature() {
        return trackTemperature;
    }

    public void setTrackTemperature(short trackTemperature) {
        this.trackTemperature = trackTemperature;
    }

    /**
     * @return Air temp. in degrees celsius
     */
    public short getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(short airTemperature) {
        this.airTemperature = airTemperature;
    }

    /**
     * @return Total number of laps in this race
     */
    public short getTotalLaps() {
        return totalLaps;
    }

    public void setTotalLaps(short totalLaps) {
        this.totalLaps = totalLaps;
    }

    /**
     * @return Track length in metres
     */
    public int getTrackLength() {
        return trackLength;
    }

    public void setTrackLength(int trackLength) {
        this.trackLength = trackLength;
    }

    /**
     * @return Session type
     * 0 = unknown, 1 = P1, 2 = P2, 3 = P3, 4 = Short P
     * 5 = Q1, 6 = Q2, 7 = Q3, 8 = Short Q, 9 = OSQ
     * 10 = R, 11 = R2, 12 = Time Trial
     */
    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    /**
     * @return Track ID
     * -1 for unknown, 0-21 for tracks, see appendix
     */
    public Track getTrackId() {
        return trackId;
    }

    public void setTrackId(Track trackId) {
        this.trackId = trackId;
    }

    /**
     * @return Formula
     * Formula, 0 = F1 Modern, 1 = F1 Classic, 2 = F2, 3 = F1 Generic
     */
    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    /**
     * @return Time left in session in seconds
     */
    public int getSessionTimeLeft() {
        return sessionTimeLeft;
    }

    public void setSessionTimeLeft(int sessionTimeLeft) {
        this.sessionTimeLeft = sessionTimeLeft;
    }

    /**
     * @return Session duration in seconds
     */
    public int getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(int sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    /**
     * @return Pit speed limit in kilometres per hour
     */
    public short getPitSpeedLimit() {
        return pitSpeedLimit;
    }

    public void setPitSpeedLimit(short pitSpeedLimit) {
        this.pitSpeedLimit = pitSpeedLimit;
    }

    /**
     * @return Whether the game is paused
     */
    public short getGamePaused() {
        return gamePaused;
    }

    public void setGamePaused(short gamePaused) {
        this.gamePaused = gamePaused;
    }

    /**
     * @return Whether the player is spectating
     */
    public short getIsSpectating() {
        return isSpectating;
    }

    public void setIsSpectating(short isSpectating) {
        this.isSpectating = isSpectating;
    }

    /**
     * @return Index of the car being spectated
     */
    public short getSpectatorCarIndex() {
        return spectatorCarIndex;
    }

    public void setSpectatorCarIndex(short spectatorCarIndex) {
        this.spectatorCarIndex = spectatorCarIndex;
    }

    /**
     * @return SLI Pro support, 0 = inactive, 1 = active
     */
    public short getSliProNativeSupport() {
        return sliProNativeSupport;
    }

    public void setSliProNativeSupport(short sliProNativeSupport) {
        this.sliProNativeSupport = sliProNativeSupport;
    }

    /**
     * @return Number of marshal zones to follow
     */
    public short getNumMarshalZones() {
        return numMarshalZones;
    }

    public void setNumMarshalZones(short numMarshalZones) {
        this.numMarshalZones = numMarshalZones;
    }

    /**
     * @return List of marshal zones – max 21
     */
    public List<MarshalZone> getMarshalZones() {
        return marshalZones;
    }

    public void setMarshalZones(List<MarshalZone> marshalZones) {
        this.marshalZones = marshalZones;
    }

    /**
     * @return Safety car status
     * 0 = no safety car, 1 = full safety car
     * 2 = virtual safety car
     * 0 = offline, 1 = online
     */
    public SafetyCarStatus getSafetyCarStatus() {
        return safetyCarStatus;
    }

    public void setSafetyCarStatus(SafetyCarStatus safetyCarStatus) {
        this.safetyCarStatus = safetyCarStatus;
    }

    /**
     * @return Network game
     * 0 = offline, 1 = online
     */
    public short getNetworkGame() {
        return networkGame;
    }

    public void setNetworkGame(short networkGame) {
        this.networkGame = networkGame;
    }

    /**
     * @return Number of weather samples to follow
     */
    public short getNumWeatherForecastSamples() {
        return numWeatherForecastSamples;
    }

    public void setNumWeatherForecastSamples(short numWeatherForecastSamples) {
        this.numWeatherForecastSamples = numWeatherForecastSamples;
    }

    /**
     * @return List of weather forecast samples
     */
    public List<WeatherForecastSample> getWeatherForecastSamples() {
        return weatherForecastSamples;
    }

    public void setWeatherForecastSamples(List<WeatherForecastSample> weatherForecastSamples) {
        this.weatherForecastSamples = weatherForecastSamples;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SessionData[");
        sb.append(super.toString());
        sb.append(",weather=" + this.weather);
        sb.append(",trackTemperature=" + this.trackTemperature);
        sb.append(",airTemperature=" + this.airTemperature);
        sb.append(",totalLaps=" + this.totalLaps);
        sb.append(",trackLength=" + this.trackLength);
        sb.append(",sessionType=" + this.sessionType);
        sb.append(",trackId=" + this.trackId);
        sb.append(",formula=" + this.formula);
        sb.append(",sessionTimeLeft=" + this.sessionTimeLeft);
        sb.append(",sessionDuration=" + this.sessionDuration);
        sb.append(",pitSpeedLimit=" + this.pitSpeedLimit);
        sb.append(",gamePaused=" + this.gamePaused);
        sb.append(",isSpectating=" + this.isSpectating);
        sb.append(",spectatorCarIndex" + this.spectatorCarIndex);
        sb.append(",sliProNativeSupport=" + this.sliProNativeSupport);
        sb.append(",numMarshalZones=" + this.numMarshalZones);
        sb.append(",marshalZones=");
        for (MarshalZone mz: marshalZones) {
            sb.append(mz.toString() + ",");
        }
        sb.append("safetyCarStatus=" + this.safetyCarStatus);
        sb.append(",networkGame=" + this.networkGame);
        sb.append(",numWeatherForecastSamples=" + this.numWeatherForecastSamples);
        sb.append(",weatherForecastSamples=");
        for (WeatherForecastSample wfs : weatherForecastSamples) {
            sb.append(wfs.toString() + ",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        this.weather = Weather.valueOf(buffer.readUnsignedByte());
        this.trackTemperature = buffer.readByte();
        this.airTemperature = buffer.readByte();
        this.totalLaps = buffer.readUnsignedByte();
        this.trackLength = buffer.readUnsignedShortLE();
        this.sessionType = SessionType.valueOf(buffer.readUnsignedByte());
        this.trackId = Track.valueOf(buffer.readByte());
        this.formula = Formula.valueOf(buffer.readUnsignedByte());
        this.sessionTimeLeft = buffer.readUnsignedShortLE();
        this.sessionDuration = buffer.readUnsignedShortLE();
        this.pitSpeedLimit = buffer.readUnsignedByte();
        this.gamePaused = buffer.readUnsignedByte();
        this.isSpectating = buffer.readUnsignedByte();
        this.spectatorCarIndex = buffer.readUnsignedByte();
        this.sliProNativeSupport = buffer.readUnsignedByte();
        this.numMarshalZones = buffer.readUnsignedByte();
        for (int i = 0; i < PacketConstants.MARSHAL_ZONES; i++) {
            MarshalZone mz = new MarshalZone();
            mz.setZoneStart(buffer.readFloat());
            mz.setZoneFlag(ZoneFlag.valueOf(buffer.readByte()));
            this.marshalZones.add(mz);
        }
        this.safetyCarStatus = SafetyCarStatus.valueOf(buffer.readUnsignedByte());
        this.networkGame = buffer.readUnsignedByte();
        this.numWeatherForecastSamples = buffer.readUnsignedByte();
        for (int i = 0; i < PacketConstants.WEATHER_FORECAST_SAMPLES; i++) {
            WeatherForecastSample wfs = new WeatherForecastSample();
            wfs.setSessionType(SessionType.valueOf(buffer.readUnsignedByte()));
            wfs.setTimeOffset(buffer.readUnsignedByte());
            wfs.setWeather(Weather.valueOf(buffer.readUnsignedByte()));
            wfs.setTrackTemperature(buffer.readByte());
            wfs.setAirTemperature(buffer.readByte());
            this.weatherForecastSamples.add(wfs);
        }
        return this;
    }

    class MarshalZone {

        private float zoneStart;
        public ZoneFlag zoneFlag;

        /**
         * @return Zone start
         * Fraction (0..1) of way through the lap the marshal zone starts
         */
        public float getZoneStart() {
            return zoneStart;
        }

        public void setZoneStart(float zoneStart) {
            this.zoneStart = zoneStart;
        }

        /**
         * @return Zone flag
         * -1 = invalid/unknown, 0 = none, 1 = green, 2 = blue, 3 = yellow, 4 = red
         */
        public ZoneFlag getZoneFlag() {
            return zoneFlag;
        }

        public void setZoneFlag(ZoneFlag zoneFlag) {
            this.zoneFlag = zoneFlag;
        }
        
        @Override
        public String toString() {
            return "MarshalZone[zoneStart=" + this.zoneStart +
                    ",zoneFlag=" + this.zoneFlag +
                    "]";
        }
    }

    class WeatherForecastSample {
        
        private SessionType sessionType;
        private short timeOffset;
        private Weather weather;
        private short trackTemperature;
        private short airTemperature;

        /**
         * @return Session type
         * 0 = unknown, 1 = P1, 2 = P2, 3 = P3, 4 = Short P, 5 = Q1
         * 6 = Q2, 7 = Q3, 8 = Short Q, 9 = OSQ, 10 = R, 11 = R2
         * 12 = Time Trial
         */
        public SessionType getSessionType() {
            return sessionType;
        }

        public void setSessionType(SessionType sessionType) {
            this.sessionType = sessionType;
        }

        /**
         * @return Time in minutes the forecast is for
         */
        public short getTimeOffset() {
            return timeOffset;
        }

        public void setTimeOffset(short timeOffset) {
            this.timeOffset = timeOffset;
        }

        /**
         * @return Weather
         * Weather - 0 = clear, 1 = light cloud, 2 = overcast
         * 3 = light rain, 4 = heavy rain, 5 = storm
         */
        public Weather getWeather() {
            return weather;
        }

        public void setWeather(Weather weather) {
            this.weather = weather;
        }

        /**
         * @return Track temp. in degrees celsius
         */
        public short getTrackTemperature() {
            return trackTemperature;
        }

        public void setTrackTemperature(short trackTemperature) {
            this.trackTemperature = trackTemperature;
        }

        /**
         * @return Air temp. in degrees celsius
         */
        public short getAirTemperature() {
            return airTemperature;
        }

        public void setAirTemperature(short airTemperature) {
            this.airTemperature = airTemperature;
        }

        @Override
        public String toString() {
            return "WeatherForecastSample[sessionType=" + this.sessionType +
                    ",timeOffset=" + this.timeOffset +
                    ",weather=" + this.weather +
                    ",trackTemperature=" + this.trackTemperature +
                    ",airTemperature=" + this.airTemperature +
                    "]";
        }
    }
}